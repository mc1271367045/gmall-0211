package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.sms.entity.SmsHomeAdvEntity;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-06 12:37:23
 */
public interface SmsHomeAdvService extends IService<SmsHomeAdvEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

