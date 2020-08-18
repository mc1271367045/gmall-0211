package com.atguigu.gmall.search.pojo;

import com.atguigu.gmall.pms.entity.BrandEntity;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/18/20:10
 * @Description:
 */
@Data
public class SearchResponseVo {

    // 封装品牌的过滤条件
    private List<BrandEntity> brands;
    // 封装分类的过滤条件
    private List<CategoryEntity> categories;
    // 封装规格参数过滤条件
    private List<SearchResponseAttrVo> filters;

    private Integer pageNum;
    private Integer pageSize;
    private Long total;

    private List<Goods> goodsList;
}
