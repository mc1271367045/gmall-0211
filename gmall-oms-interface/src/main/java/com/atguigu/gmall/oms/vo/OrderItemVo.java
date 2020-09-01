package com.atguigu.gmall.oms.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/31/18:25
 * @Description:
 */
@Data
public class OrderItemVo {

    private Long skuId;
    private String defaultImage;
    private String title;
    private List saleAttrs; // 销售属性：List<SkuAttrValueEntity>的json格式
    private BigDecimal price; // 加入购物车时的价格
    private BigDecimal count;
    private Boolean store = false; // 是否有货
    private List sales; // 营销信息: List<ItemSaleVo>的json格式
    private BigDecimal weight; // 重量 涉及到计算 使用BigDecimal

}
