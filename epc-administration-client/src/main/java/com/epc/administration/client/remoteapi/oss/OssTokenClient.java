package com.epc.administration.client.remoteapi.oss;

import com.epc.web.facade.oss.FacadeOssTokenService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 19:48
 * <p>@Author : luozhixin
 */
@FeignClient(value = "EPC-OSSFILE-SERVICE",fallback = OssTokenHystrix.class)
public interface OssTokenClient  extends FacadeOssTokenService {
}
