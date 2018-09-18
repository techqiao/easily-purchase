package com.epc.web.client.remoteApi.supplier;

import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-web-service",fallback = SupplierHystrixImpl.class)
public interface SupplierClient extends FacadeTSupplierBasicInfoService {
}
