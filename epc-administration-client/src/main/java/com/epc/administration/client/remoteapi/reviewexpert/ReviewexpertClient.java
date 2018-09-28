package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewExpertService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-platform-service" ,fallback = ReviewexpertHystrix.class)
public interface ReviewexpertClient  extends ReviewExpertService {
}
