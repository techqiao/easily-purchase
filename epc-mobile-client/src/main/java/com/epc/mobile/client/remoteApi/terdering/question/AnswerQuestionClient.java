package com.epc.mobile.client.remoteApi.terdering.question;

import com.epc.web.facade.terdering.answer.FacadeAnswerQuestionService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:39
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-tendering-service",fallback = AnswerQuestionHystrix.class)
public interface AnswerQuestionClient extends FacadeAnswerQuestionService {
}
