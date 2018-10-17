package com.epc.mobile.client.remoteApi.terdering.committee;


import com.epc.web.facade.terdering.committee.FacadeCommitteeService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-tendering-service",fallback = CommitteeHystrix.class)
public interface CommitteeClient extends FacadeCommitteeService {
}
