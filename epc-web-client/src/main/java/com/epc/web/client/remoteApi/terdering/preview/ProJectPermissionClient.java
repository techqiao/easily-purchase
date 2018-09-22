package com.epc.web.client.remoteApi.terdering.preview;

import com.epc.web.facade.terdering.preview.ProJectPermissionService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-tendering-service",fallback = ProJectPermissionHystrix.class)
public interface ProJectPermissionClient extends ProJectPermissionService {
}
