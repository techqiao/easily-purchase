package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminResourceService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:19
 * <p>@Author : luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = adminResourceHystrix.class)
public interface adminResourceClient extends AdminResourceService {
}
