package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import lombok.Data;

import java.util.List;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/12/18:12
 * @Description:
 */
@Data
public class AttrGroupVo extends AttrGroupEntity {

    private List<AttrEntity> attrEntities;

}
