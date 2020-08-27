package com.atguigu.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.ums.entity.UserEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-26 19:42:02
 */
public interface UserService extends IService<UserEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    // 数据校验是否可用
    Boolean checkData(String data, Integer type);

    // 用户注册
    void register(UserEntity user, String code);

    // 查询用户
    UserEntity queryUser(String loginName, String password);

}

