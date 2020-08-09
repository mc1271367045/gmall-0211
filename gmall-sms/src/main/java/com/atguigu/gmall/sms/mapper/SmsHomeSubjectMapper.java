package com.atguigu.gmall.sms.mapper;

import com.atguigu.gmall.sms.entity.SmsHomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-06 12:37:22
 */
@Mapper
public interface SmsHomeSubjectMapper extends BaseMapper<SmsHomeSubjectEntity> {
	
}
