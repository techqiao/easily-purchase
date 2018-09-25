package com.epc.web.client.remoteApi.bidding.sign;

import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(value = "epc-bidding-service",fallback = SignHystrix.class)
public interface SupplierBaseClient extends FacadeTSupplierBasicInfoService {
}
