package com.epc.administration.client.remoteapi.user;

import com.epc.administration.facade.user.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */
@FeignClient(value = "epc-platform-service",fallback = HelloServiceHystrix.class)
public interface HelloServiceClient extends UserService {

}

