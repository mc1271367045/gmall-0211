package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.sms.entity.SmsSeckillSkuEntity;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-06 12:37:22
 */
public interface SmsSeckillSkuService extends IService<SmsSeckillSkuEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

