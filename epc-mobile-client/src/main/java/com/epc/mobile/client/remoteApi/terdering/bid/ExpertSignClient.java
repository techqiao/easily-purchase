package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeExpertSignService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:53
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = ExpertSignHystrix.class)
public interface ExpertSignClient extends FacadeExpertSignService {
}
