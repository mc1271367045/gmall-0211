package com.atguigu.gmall.order.feign;

import com.atguigu.gmall.oms.api.GmallOmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/09/01/13:55
 * @Description:
 */
@FeignClient("oms-service")
public interface GmallOmsClient extends GmallOmsApi {
}
