package com.epc.web.client.remoteApi.supplier;

import com.epc.web.client.remoteApi.OperatorHystrix;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-platform-service",fallback = OperatorHystrix.class)
public interface SupplierClient extends FacadeTSupplierBasicInfoService {
}
