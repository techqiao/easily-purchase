package com.epc.web.client.remoteApi.pretrial;

import com.epc.web.facade.terdering.pretrial.FacadePretrialMessageService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:51
 * <p>@Author : wjq
 */
@FeignClient(value = "epc-web-service",fallback = FacadePretrialMessageHystrix.class)
public interface FacadePretrialMessageClient extends FacadePretrialMessageService {
}
