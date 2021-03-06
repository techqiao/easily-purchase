package com.epc.administration.client.remoteapi.biddingagency;

import com.epc.administration.facade.biddingagency.BiddingAgencyService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:09
 * <p>@author : wjq
 */
@FeignClient(value = "epc-platform-service",fallback = BiddingAgencyHystrix.class)
public interface BiddingAgencyClient extends BiddingAgencyService {

}
