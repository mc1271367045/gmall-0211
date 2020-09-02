package com.atguigu.gmall.payment.controller;

import com.alipay.api.AlipayApiException;
import com.atguigu.gmall.common.exception.OrderException;
import com.atguigu.gmall.oms.entity.OrderEntity;
import com.atguigu.gmall.oms.entity.OrderReturnApplyEntity;
import com.atguigu.gmall.payment.config.AlipayTemplate;
import com.atguigu.gmall.payment.entity.PaymentInfoEntity;
import com.atguigu.gmall.payment.service.PaymentService;
import com.atguigu.gmall.payment.vo.PayAsyncVo;
import com.atguigu.gmall.payment.vo.PayVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/09/01/20:34
 * @Description:
 */
@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AlipayTemplate alipayTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("pay.html")
    public String topay(@RequestParam("orderToken")String orderToken, Model model){

        OrderEntity orderEntity = this.paymentService.queryOrderByOrderToken(orderToken);
        if (orderEntity == null) {
            throw new OrderException("该用户对应的订单不存在！");
        }
        model.addAttribute("orderEntity", orderEntity);
        return "pay";
    }

    @GetMapping("alipay.html")
    @ResponseBody // 该方法将以其他视图形式返回：json html xml
    public String alipay(@RequestParam("orderToken")String orderToken){
        // 1 检验订单的真实性
        OrderEntity orderEntity = this.paymentService.queryOrderByOrderToken(orderToken);
        if (orderEntity == null) {
            throw new OrderException("该用户对应的订单不存在！");
        }

        try {
            // 2. 整合参数
            PayVo payVo = new PayVo();
            payVo.setOut_trade_no(orderToken);
            String price = StringUtils.substring(orderEntity.getPayAmount().toString(), 0, StringUtils.lastIndexOf(orderEntity.getPayAmount().toString(), ".") + 3);
            payVo.setTotal_amount(price); // 填一个模拟数据
            //payVo.setTotal_amount("0.01");
            payVo.setSubject("谷粒商城支付系统");

            // 3. 记录对账表
            Long paymentId = this.paymentService.savePayment(orderEntity, price);
            payVo.setPassback_params(paymentId.toString());

            // 4. 调用阿里接口，获取支付表单
            return this.alipayTemplate.pay(payVo);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        throw new OrderException("支付接口调用异常，请稍后再试！");
    }

    // 异步回调
    @PostMapping("pay/success")
    public String paySuccess(PayAsyncVo payAsyncVo){
        // 1.验签
        Boolean flag = this.alipayTemplate.verifySignature(payAsyncVo);
        if (!flag){
            return "failure";
        }

        // 2.校验业务参数：app_id、out_trade_no、total_amount
        String out_trade_no = payAsyncVo.getOut_trade_no();
        String app_id = payAsyncVo.getApp_id();
        String total_amount = payAsyncVo.getTotal_amount();
        String paymentId = payAsyncVo.getPassback_params();
        if (StringUtils.isBlank(paymentId)){
            return "failure";
        }
        PaymentInfoEntity paymentInfoEntity = this.paymentService.queryPaymentById(paymentId);
        if (!StringUtils.equals(out_trade_no, paymentInfoEntity.getOutTradeNo())
                || !StringUtils.equals(app_id, this.alipayTemplate.getApp_id())
                || paymentInfoEntity.getTotalAmount().compareTo(new BigDecimal(total_amount)) != 0){
            return "failure";
        }

        // 3.判断交易状态：TRADE_SUCCESS
        if (!StringUtils.equals("TRADE_SUCCESS", payAsyncVo.getTrade_status())){
            return "failure";
        }

        // 4.完成业务处理
        // 4.1. 更新对账记录，已付款
        this.paymentService.updatePayment(payAsyncVo);

        // 4.2. 更新订单状态，待发货（减库存）
        this.rabbitTemplate.convertAndSend("ORDER-EXCHANGE", "order.success", payAsyncVo.getOut_trade_no());

        // 5.返回success
        return "success";
    }

    // 同步回调
    @GetMapping("pay/ok")
    public String payOk(){

        return "paysuccess";
    }




}
