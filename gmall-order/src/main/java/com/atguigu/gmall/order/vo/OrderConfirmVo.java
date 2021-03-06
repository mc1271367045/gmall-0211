package com.atguigu.gmall.order.vo;

import com.atguigu.gmall.oms.vo.OrderItemVo;
import com.atguigu.gmall.ums.entity.UserAddressEntity;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/31/18:20
 * @Description:
 */
@Data
public class OrderConfirmVo {

    // 收货人列表
    private List<UserAddressEntity> addresses;

    // 送货清单
    private List<OrderItemVo> items;

    // 购物积分
    private Integer bounds;

    // 防重的唯一标识
    private String orderToken;

}
