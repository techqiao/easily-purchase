package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminLoginService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 11:01
 * <p>@Author : luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = AdminLoginHystrix.class)
public interface AdminLoginClient extends AdminLoginService {
}
