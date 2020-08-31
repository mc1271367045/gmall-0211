package com.atguigu.gmall.ums.api;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.ums.entity.UserAddressEntity;
import com.atguigu.gmall.ums.entity.UserEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/26/20:57
 * @Description:
 */
public interface GmallUmsApi {
    @GetMapping("ums/user/query")
    ResponseVo<UserEntity> queryUser(@RequestParam("loginName")String loginName, @RequestParam("password")String password);

    @GetMapping("ums/useraddress/user/{userId}")
    public ResponseVo<List<UserAddressEntity>> queryAddressByUserId(@PathVariable("userId")Long userId);

    @GetMapping("ums/user/{id}")
    ResponseVo<UserEntity> queryUserById(@PathVariable("id") Long id);


}
