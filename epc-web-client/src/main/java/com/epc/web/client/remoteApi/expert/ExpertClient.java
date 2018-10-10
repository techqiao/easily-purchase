package com.epc.web.client.remoteApi.expert;

import com.epc.web.client.remoteApi.agency.AgencyHystrix;
import com.epc.web.facade.expert.FacadeExpertService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-web-user-service",fallback = ExpertHystrix.class)
public interface  ExpertClient extends FacadeExpertService {
}
