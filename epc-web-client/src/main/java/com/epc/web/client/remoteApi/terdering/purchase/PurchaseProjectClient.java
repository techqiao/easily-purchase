package com.epc.web.client.remoteApi.terdering.purchase;

import com.epc.web.facade.terdering.purchase.FacadeTPurchaseProjectBasicInfoService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 17:35
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = PurchaseProjectHystrix.class)
public interface PurchaseProjectClient extends FacadeTPurchaseProjectBasicInfoService {

}
