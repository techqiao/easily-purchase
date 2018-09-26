package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminRoleService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:51
 * <p>@Author : luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = AdminRoleHystrix.class)
public interface AdminRoleClient extends AdminRoleService {
}
