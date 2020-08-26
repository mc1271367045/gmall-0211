package com.atguigu.gmall.ums.mapper;

import com.atguigu.gmall.ums.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-26 19:42:02
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
