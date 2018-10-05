package com.epc.web.client.remoteApi.bidding.procedure;

import com.epc.web.facade.bidding.FacadeProcedureService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author linzhxiaing
 */
@FeignClient(value = "epc-bidding-service",fallback = ProcedureHystrix.class)

public interface ProcedureClient extends FacadeProcedureService {

}
