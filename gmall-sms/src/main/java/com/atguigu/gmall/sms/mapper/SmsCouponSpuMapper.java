package com.atguigu.gmall.sms.mapper;

import com.atguigu.gmall.sms.entity.SmsCouponSpuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-06 12:37:23
 */
@Mapper
public interface SmsCouponSpuMapper extends BaseMapper<SmsCouponSpuEntity> {
	
}
