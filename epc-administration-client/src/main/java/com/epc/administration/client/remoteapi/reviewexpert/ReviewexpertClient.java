package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewExpertService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-platform-service",fallback = ReviewExpertHystrix.class)
public interface ReviewExpertClient extends ReviewExpertService {
}
