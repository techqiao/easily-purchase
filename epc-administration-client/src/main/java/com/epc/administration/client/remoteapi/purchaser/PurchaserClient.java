package com.epc.administration.client.remoteapi.purchaser;


import com.epc.administration.facade.purchaser.PurchaserUserService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 20:42:17
 * <p>@author :lzx
 */
@FeignClient(value = "epc-platform-service",fallback = PurchaserHystrix.class)
public interface PurchaserClient extends PurchaserUserService {

}
