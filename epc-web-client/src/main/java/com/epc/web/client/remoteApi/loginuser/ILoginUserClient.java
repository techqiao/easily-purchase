package com.epc.web.client.remoteApi.loginuser;

import com.epc.web.facade.loginuser.FacadeLoginUserService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "epc-web-service" ,fallback = LoginUserHystrix.class)
public interface ILoginUserClient extends FacadeLoginUserService {
}
