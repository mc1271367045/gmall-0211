package com.atguigu.gmall.auth.feign;

import com.atguigu.gmall.ums.api.GmallUmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: Gork_Mc
 * @Date: 2020/08/27/16:29
 * @Description:
 */

@FeignClient("ums-service")
public interface GmallUmsClient extends GmallUmsApi {
}

