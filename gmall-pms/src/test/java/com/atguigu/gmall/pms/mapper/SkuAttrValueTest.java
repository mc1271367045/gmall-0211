package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.service.SkuAttrValueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/25/20:15
 * @Description:
 */
@SpringBootTest
public class SkuAttrValueTest {

    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    private SkuAttrValueService skuAttrValueService;

    @Test
    public void test(){
        List<Map<String, Object>> maps = this.skuAttrValueMapper.querySaleAttrMappingSkuIdBySpuId(31l);
        System.out.println(maps);
        String s = this.skuAttrValueService.querySaleAttrMappingSkuIdBySpuId(31l);
        System.out.println(s);
    }

}
