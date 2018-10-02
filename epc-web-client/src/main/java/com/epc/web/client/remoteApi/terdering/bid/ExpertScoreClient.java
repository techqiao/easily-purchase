package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeExpertScoreService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 11:26
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = ExpertScoreHystrix.class)
public interface ExpertScoreClient extends FacadeExpertScoreService {
}
