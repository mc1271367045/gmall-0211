package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 品牌分类关联
 * 
 * @author Gork
 * @email 1271367045@qq.com.com
 * @date 2020-08-05 20:37:57
 */
@Data
@TableName("pms_category_brand")
public class CategoryBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 品牌id
	 */
	private Long brandId;
	/**
	 * 分类id
	 */
	private Long categoryId;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 分类名称
	 */
	private String categoryName;

}
