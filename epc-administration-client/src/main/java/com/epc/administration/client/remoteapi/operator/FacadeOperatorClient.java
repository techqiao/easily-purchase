package com.epc.administration.client.remoteapi.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:09
 * <p>@author : wjq
 */
@FeignClient(value = "epc-platform-service",fallback = FacadeOperatorHystrix.class)
public interface FacadeOperatorClient extends FacadeOperatorService {

}
