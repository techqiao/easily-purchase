package com.epc.web.client.remoteApi.bidding.winBid;

import com.epc.web.facade.bidding.FacadeWinBidService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-bidding-service",fallback = WinBidHystrix.class)
public interface WinBidClient extends FacadeWinBidService {
}
