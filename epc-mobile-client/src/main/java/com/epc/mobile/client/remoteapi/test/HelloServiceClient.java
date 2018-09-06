package com.epc.mobile.client.remoteapi.test;

import com.epc.api.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */
@FeignClient("epc-mobile-service")
public interface HelloServiceClient extends HelloService {

}

