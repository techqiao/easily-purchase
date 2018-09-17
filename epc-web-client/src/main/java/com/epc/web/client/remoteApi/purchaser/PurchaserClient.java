package com.epc.web.client.remoteApi.purchaser;

import com.epc.web.facade.purchaser.FacadePurchaserService;
import org.springframework.cloud.netflix.feign.FeignClient;


    @FeignClient(value = "epc-web-service",fallback = PurchaserHystrix.class)
    public interface PurchaserClient extends FacadePurchaserService {

    }

