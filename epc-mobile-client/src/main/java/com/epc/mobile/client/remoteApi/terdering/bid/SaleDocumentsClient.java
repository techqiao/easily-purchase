package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeSaleDocumentsService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 15:03
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = SaleDocumentsHystrix.class)
public interface SaleDocumentsClient extends FacadeSaleDocumentsService {
}
