package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.SpuEntity;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/12/18:48
 * @Description:
 */
@Data
public class SpuVo extends SpuEntity {

    private List<String> spuImages;

    private List<BaseAttrValueVo> baseAttrs;

    private List<SkuVo> skus;
}
