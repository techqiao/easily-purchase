package com.epc.web.client.remoteApi.bidding.sign;


import com.epc.web.facade.bidding.FacadeSignService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-bidding-service",fallback = SignHystrix.class)

public interface SignClient extends FacadeSignService {
}
