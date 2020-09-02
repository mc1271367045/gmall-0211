package com.atguigu.gmall.oms.api;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.oms.entity.OrderEntity;
import com.atguigu.gmall.oms.vo.OrderSubmitVo;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/09/01/8:40
 * @Description:
 */
public interface GmallOmsApi {
    @PostMapping("oms/order/submit/{userId}")
    ResponseVo<OrderEntity> saveOrder(@RequestBody OrderSubmitVo submitVo, @PathVariable("userId")Long userId);

    @GetMapping("oms/order/token/{orderToken}")
    ResponseVo<OrderEntity> queryOrderByToken(@PathVariable("orderToken")String orderToken, @RequestParam("userId")Long userId);
}
