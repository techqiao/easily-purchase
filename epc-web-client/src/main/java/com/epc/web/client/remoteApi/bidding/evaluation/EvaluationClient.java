package com.epc.web.client.remoteApi.bidding.evaluation;

import com.epc.web.facade.bidding.FacadeEvaluationService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:30
 * <p>@Author : luozhixin
 * <p>EvaluationClient
 */
@FeignClient(value = "epc-tendering-service",fallback = EvaluationHystrix.class)
public interface EvaluationClient  extends FacadeEvaluationService {
}
