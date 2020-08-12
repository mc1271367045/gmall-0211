package com.atguigu.gmall.sms.mapper;

import com.atguigu.gmall.sms.entity.SmsSkuFullReductionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 商品满减信息
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-06 12:37:22
 */
@Component
@Mapper
public interface SmsSkuFullReductionMapper extends BaseMapper<SmsSkuFullReductionEntity> {
	
}
