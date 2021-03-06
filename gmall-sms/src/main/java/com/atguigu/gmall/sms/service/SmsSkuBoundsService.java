package com.atguigu.gmall.sms.service;

import com.atguigu.gmall.sms.vo.ItemSaleVo;
import com.atguigu.gmall.sms.vo.SkuSaleVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.sms.entity.SmsSkuBoundsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-06 12:37:22
 */
public interface SmsSkuBoundsService extends IService<SmsSkuBoundsEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    void saveSkuSales(SkuSaleVo skuSaleVo);

    // 根据skuid查询营销信息
    List<ItemSaleVo> querySalesBySkuId(Long skuId);

}

