package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewexpertService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:09
 * <p>@author : wjq
 */
@FeignClient(value = "epc-platform-service",fallback = ReviewexpertHystrix.class)
public interface ReviewexpertClient extends ReviewexpertService {

}
