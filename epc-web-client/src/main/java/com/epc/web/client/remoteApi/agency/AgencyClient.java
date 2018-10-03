package com.epc.web.client.remoteApi.agency;

import com.epc.web.facade.agency.FacadeAgencyService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "EPC-WEB-USER-SERVICE",fallback = AgencyHystrix.class)
public interface AgencyClient extends FacadeAgencyService {
}
