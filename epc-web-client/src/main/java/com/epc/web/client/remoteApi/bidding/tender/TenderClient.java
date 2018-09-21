package com.epc.web.client.remoteApi.bidding.tender;

import com.epc.web.client.remoteApi.bidding.question.BiddingHystrix;
import com.epc.web.facade.bidding.FacadeTenderService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-bidding-service",fallback = BiddingHystrix.class)
public interface TenderClient extends FacadeTenderService {

}
