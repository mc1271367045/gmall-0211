package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.SpuDescEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * spu信息介绍
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-05 20:37:57
 */
@Component
@Mapper
public interface SpuDescMapper extends BaseMapper<SpuDescEntity> {
	
}
