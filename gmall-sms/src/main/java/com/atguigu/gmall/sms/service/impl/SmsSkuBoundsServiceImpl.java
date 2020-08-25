package com.atguigu.gmall.sms.service.impl;

import com.atguigu.gmall.sms.entity.SmsSkuFullReductionEntity;
import com.atguigu.gmall.sms.entity.SmsSkuLadderEntity;
import com.atguigu.gmall.sms.mapper.SmsSkuFullReductionMapper;
import com.atguigu.gmall.sms.mapper.SmsSkuLadderMapper;
import com.atguigu.gmall.sms.vo.ItemSaleVo;
import com.atguigu.gmall.sms.vo.SkuSaleVo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.sms.mapper.SmsSkuBoundsMapper;
import com.atguigu.gmall.sms.entity.SmsSkuBoundsEntity;
import com.atguigu.gmall.sms.service.SmsSkuBoundsService;
import org.springframework.transaction.annotation.Transactional;


@Service("smsSkuBoundsService")
public class SmsSkuBoundsServiceImpl extends ServiceImpl<SmsSkuBoundsMapper, SmsSkuBoundsEntity> implements SmsSkuBoundsService {

    @Autowired
    private SmsSkuFullReductionMapper reductionMapper;

    @Autowired
    private SmsSkuLadderMapper ladderMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<SmsSkuBoundsEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<SmsSkuBoundsEntity>()
        );

        return new PageResultVo(page);
    }

    @Transactional
    @Override
    public void saveSkuSales(SkuSaleVo skuSaleVo) {
        // 3.1. 保存积分信息
        SmsSkuBoundsEntity skuBoundsEntity = new SmsSkuBoundsEntity();
        BeanUtils.copyProperties(skuSaleVo, skuBoundsEntity);
        List<Integer> works = skuSaleVo.getWork();
        if (!CollectionUtils.isEmpty(works) && works.size() == 4){
            skuBoundsEntity.setWork(works.get(3) * 8 + works.get(2) * 4 + works.get(1) * 2 + works.get(0));
        }
        this.save(skuBoundsEntity);

        // 3.2. 保存满减信息
        SmsSkuFullReductionEntity reductionEntity = new SmsSkuFullReductionEntity();
        BeanUtils.copyProperties(skuSaleVo, reductionEntity);
        reductionEntity.setAddOther(skuSaleVo.getFullAddOther());
        this.reductionMapper.insert(reductionEntity);

        // 3.3. 保存打折信息
        SmsSkuLadderEntity skuLadderEntity = new SmsSkuLadderEntity();
        BeanUtils.copyProperties(skuSaleVo, skuLadderEntity);
        skuLadderEntity.setAddOther(skuSaleVo.getLadderAddOther());
        this.ladderMapper.insert(skuLadderEntity);
    }

    // 根据skuid查询营销信息
    @Override
    public List<ItemSaleVo> querySalesBySkuId(Long skuId) {
        List<ItemSaleVo> itemSaleVos = new ArrayList<>();
        // 查询积分优惠
        SmsSkuBoundsEntity skuBoundsEntity = this.getOne(new QueryWrapper<SmsSkuBoundsEntity>().eq("sku_id", skuId));
        if (skuBoundsEntity != null){
            ItemSaleVo boundsSaleVo = new ItemSaleVo();
            boundsSaleVo.setType("积分");
            boundsSaleVo.setDesc("送" + skuBoundsEntity.getGrowBounds() + "成长积分，送" + skuBoundsEntity.getBuyBounds() + "购物积分");
            itemSaleVos.add(boundsSaleVo);
        }

        // 满减优惠
        SmsSkuFullReductionEntity reductionEntity = this.reductionMapper.selectOne(new QueryWrapper<SmsSkuFullReductionEntity>().eq("sku_id", skuId));
        if (reductionEntity != null) {
            ItemSaleVo reductionSaleVo = new ItemSaleVo();
            reductionSaleVo.setType("满减");
            reductionSaleVo.setDesc("满" + reductionEntity.getFullPrice() + "减" + reductionEntity.getReducePrice());
            itemSaleVos.add(reductionSaleVo);
        }

        // 打折优惠
        SmsSkuLadderEntity ladderEntity = this.ladderMapper.selectOne(new QueryWrapper<SmsSkuLadderEntity>().eq("sku_id", skuId));
        if (ladderEntity != null) {
            ItemSaleVo ladderSaleVo = new ItemSaleVo();
            ladderSaleVo.setType("打折");
            ladderSaleVo.setDesc("满" + ladderEntity.getFullCount() + "件，打" + ladderEntity.getDiscount().divide(new BigDecimal(10)) + "折");
            itemSaleVos.add(ladderSaleVo);
        }

        return itemSaleVos;
    }

}