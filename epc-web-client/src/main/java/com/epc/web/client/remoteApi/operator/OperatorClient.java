package com.epc.web.client.remoteApi.operator;

import com.epc.web.facade.operator.FacadeOperatorService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Description : easily-purchase
 * @author lin
 */
@FeignClient(value = "epc-web-service",fallback = OperatorHystrix.class)
public interface OperatorClient extends FacadeOperatorService {

}
