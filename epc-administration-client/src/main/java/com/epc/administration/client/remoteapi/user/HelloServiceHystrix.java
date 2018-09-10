package com.epc.administration.client.remoteapi.user;

import com.epc.administration.facade.user.HelloService;

/**
 * <p>Description : 熔断器
 * <p>Date : 2018-09-10  17:58
 * <p>@author : wjq
 */
public class HelloServiceHystrix implements HelloService {

    @Override
    public String hello(String name) {
        return null;
    }
}
