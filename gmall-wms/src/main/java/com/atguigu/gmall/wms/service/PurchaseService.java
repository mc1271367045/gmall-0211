package com.atguigu.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.wms.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-12 13:20:13
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

