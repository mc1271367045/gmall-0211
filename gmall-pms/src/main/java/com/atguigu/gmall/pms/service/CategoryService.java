package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-05 20:37:57
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    List<CategoryEntity> queryCategoriesWithSubByPid(Long pid);

    // 根据三级分类的id查询一二三及分类
    List<CategoryEntity> query123CategoriesByCid3(Long cid);
}

