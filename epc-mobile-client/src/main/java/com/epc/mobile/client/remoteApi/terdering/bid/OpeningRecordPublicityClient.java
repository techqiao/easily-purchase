package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeOpeningRecordPublicityService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 18:20
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = OpeningRecordPublicityHystrix.class)
public interface OpeningRecordPublicityClient extends FacadeOpeningRecordPublicityService {
}
