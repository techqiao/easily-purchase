package com.epc.mobile.client.remoteApi.terdering.bid;

import com.epc.web.facade.terdering.bid.FacadeOpeningRecordService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 15:18
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = OpeningRecordHystrix.class)
public interface OpeningRecordClient extends FacadeOpeningRecordService {
}
