package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminDeptService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:21
 * <p>@Author : luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = AdminDeptHystrix.class)
public interface AdminDeptClient extends AdminDeptService {

}
