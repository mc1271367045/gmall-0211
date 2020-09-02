package com.atguigu.gmall.wms.mapper;

import com.atguigu.gmall.wms.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品库存
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-12 13:20:13
 */
@Mapper
public interface WareSkuMapper extends BaseMapper<WareSkuEntity> {

    public List<WareSkuEntity> check(@Param("skuId") Long skuId, @Param("count") Integer count);

    public int lock(@Param("id")Long id, @Param("count")Integer count);

    public int unlock(@Param("id")Long id, @Param("count")Integer count);

    public int minusStock(@Param("id")Long id, @Param("count")Integer count);
}
