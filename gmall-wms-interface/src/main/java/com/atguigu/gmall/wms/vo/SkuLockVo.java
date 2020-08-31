package com.atguigu.gmall.wms.vo;

import lombok.Data;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/31/20:58
 * @Description:
 */
@Data
public class SkuLockVo {
    private Long skuId;
    private Integer count;
    private Boolean lock; // 锁定状态
    private Long wareSkuId; // 记录锁定成功的仓库的id
}

