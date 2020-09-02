package com.atguigu.gmall.payment.feign;

import com.atguigu.gmall.oms.api.GmallOmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/09/01/20:34
 * @Description:
 */
@FeignClient("oms-service")
public interface GmallOmsClient extends GmallOmsApi {
}
