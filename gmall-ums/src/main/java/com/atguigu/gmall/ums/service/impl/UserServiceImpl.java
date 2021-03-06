package com.atguigu.gmall.ums.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.ums.mapper.UserMapper;
import com.atguigu.gmall.ums.entity.UserEntity;
import com.atguigu.gmall.ums.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<UserEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<UserEntity>()
        );

        return new PageResultVo(page);
    }

    // 数据校验是否可用
    @Override
    public Boolean checkData(String data, Integer type) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        // 1，用户名；2，手机；3，邮箱
        switch (type) {
            case 1: wrapper.eq("username", data); break;
            case 2: wrapper.eq("phone", data); break;
            case 3: wrapper.eq("email", data); break;
            default: return null;
        }

        return this.count(wrapper) == 0;
    }

    // 用户注册
    @Override
    public void register(UserEntity user, String code) {
        // 1. 校验短信验证码（查询redis中的验证码，和用户输入的code比较）TODO：

        // 2. 生成盐
        String salt = UUID.randomUUID().toString().substring(0, 6);
        user.setSalt(salt);

        // 3. 加盐加密
        user.setPassword(DigestUtils.md5Hex(user.getPassword() + salt));

        // 4. 用户注册
        user.setLevelId(1l);
        user.setCreateTime(new Date());
        user.setSourceType(1);
        user.setIntegration(1000);
        user.setGrowth(1000);
        user.setStatus(1);
        this.save(user);

        // 5. 删除短信验证码 TODO:

    }

    // 查询用户
    @Override
    public UserEntity queryUser(String loginName, String password) {
        // 1.先根据登录名查询用户信息
        UserEntity userEntity = this.getOne(new QueryWrapper<UserEntity>().eq("username", loginName)
                .or().eq("phone", loginName)
                .or().eq("email", loginName));

        // 2.判空
        if (userEntity == null) {
            //throw new IllegalArgumentException("用户名不合法！");
            return userEntity;
        }

        // 3.获取用户信息中的盐，并对用户输入的明文密码加盐加密
        password = DigestUtils.md5Hex(password + userEntity.getSalt());

        // 4. 比较数据库中保存的密码和用户输入的密码（加密）
        if (!StringUtils.equals(password, userEntity.getPassword())){
            //throw new IllegalArgumentException("密码不合法！");
            return null;
        }

        return userEntity;
    }

}