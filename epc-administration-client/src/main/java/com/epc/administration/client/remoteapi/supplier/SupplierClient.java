package com.epc.administration.client.remoteapi.supplier;


import com.epc.administration.facade.supplier.SupplierUserService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 20:42:17
 * <p>@author :lzx
 */
@FeignClient(value = "epc-platform-service",fallback = SupplierHystrix.class)
public interface SupplierClient extends SupplierUserService {

}
