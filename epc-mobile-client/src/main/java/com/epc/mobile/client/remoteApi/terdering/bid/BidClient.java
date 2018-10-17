package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadePurchaseProjectBidService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:21
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = BidHystrix.class)
public interface BidClient extends FacadePurchaseProjectBidService {

}
