package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminUserService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:51
 * <p>@Author : luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = SysAdminUserHystrix.class)
public interface SysAdminUserClient extends AdminUserService {
}
