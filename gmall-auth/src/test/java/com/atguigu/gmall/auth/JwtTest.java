package com.atguigu.gmall.auth;

import com.atguigu.gmall.common.utils.JwtUtils;
import com.atguigu.gmall.common.utils.RsaUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    // 别忘了创建目录
    private static final String pubKeyPath = "F:\\Java\\rsa\\rsa.pub";
    private static final String priKeyPath = "F:\\Java\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "23fghfgh@#$;/4");
    }

    // 在生成公私钥（第一个Test）之前不要打开该注释
    @BeforeEach
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("username", "liuyan");
        // 生成token
        String token = JwtUtils.generateToken(map, privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjExIiwidXNlcm5hbWUiOiJsaXV5YW4iLCJleHAiOjE1OTg1MTgwMTl9.a4njssgXU4a6l5x_Uupx-07zl-5fRoLNB9p5ZVgsLuxc4uZb1eI_ktZiXygMa9RGzFXv8DvLJr7N_zj_gZZ6X4QpIGtjidSiObq6_5TMbwCFf009mCAMTAvp5VzB_N89DyV2nO9TvAvTHpm83ASFXszNo2R0RrguTE7gCVI7rOdws1s29HWqiA6UWCDlxhH-kTjhy8UfBrTGX3ycCgtz4X3iAraiLkypgizO7Dvzscs4xftFifwpDjw7smPKXzLA2HuZoKW6rcwjziequ3BLhLrmJ_ibxTvwJLifXrEHkn9iSVLyma6axNnBqP-LIakKZzwvrBH7JnbuBSG8ZI5JeA";

        // 解析token
        Map<String, Object> map = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + map.get("id"));
        System.out.println("userName: " + map.get("username"));
    }
}