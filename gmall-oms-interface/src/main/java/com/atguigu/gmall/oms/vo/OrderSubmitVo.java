package com.atguigu.gmall.oms.vo;

import com.atguigu.gmall.ums.entity.UserAddressEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/31/20:21
 * @Description:
 */
@Data
public class OrderSubmitVo {
    private String orderToken; // 防重字段
    private BigDecimal totalPrice; // 验价
    private UserAddressEntity address;
    private Integer payType; // 支付方式
    private String deliveryCompany; // 配送方式

    private List<OrderItemVo> items; // 送货清单
    private Integer bounds; // 积分信息
    private BigDecimal postFee; // 邮费
}

