package com.epc.web.client.remoteApi.terdering.project;

import com.epc.web.facade.terdering.FacadeTProjectBasicInfoService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 14:14
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = ProjectHystrix.class)
public interface ProjectClient extends FacadeTProjectBasicInfoService {

}
