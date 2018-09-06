package com.epc.administration.client.remoteapi.test;


import com.epc.administration.fasade.test.HelloService;
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

