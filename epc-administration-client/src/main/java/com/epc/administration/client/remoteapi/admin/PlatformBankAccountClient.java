package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.PlatformBankAccountService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-09 13:15
 * <p>@Author : luozhixin
 */
@FeignClient(value = "epc-platform-service",fallback = PlatformBankAccountHystrix.class)
public interface PlatformBankAccountClient extends PlatformBankAccountService {
}
