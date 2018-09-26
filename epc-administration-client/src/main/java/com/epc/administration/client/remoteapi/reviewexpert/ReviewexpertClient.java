package com.epc.administration.client.remoteapi.reviewexpert;


import com.epc.administration.facade.reviewexpert.ReviewExpertService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @date 2018-9-26 16:49:24
 * @author luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = ReviewexpertHystrix.class)
public interface ReviewexpertClient extends ReviewExpertService {

}
