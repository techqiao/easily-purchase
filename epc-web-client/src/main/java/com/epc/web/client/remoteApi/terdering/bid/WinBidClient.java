package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeWinBidRecordService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-tendering-service",fallback = WinbidHystrix.class)
public interface WinBidClient extends FacadeWinBidRecordService {
}
