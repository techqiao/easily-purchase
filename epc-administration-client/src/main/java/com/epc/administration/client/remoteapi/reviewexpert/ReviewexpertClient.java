package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewexpertService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-platform-service",fallback = ReviewexpertService.class)
public interface ReviewexpertClient extends ReviewexpertService {
}
