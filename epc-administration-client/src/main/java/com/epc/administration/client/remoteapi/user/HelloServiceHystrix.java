package com.epc.administration.client.remoteapi.user;

import com.epc.administration.facade.user.UserService;

/**
 * <p>Description : 熔断器
 * <p>Date : 2018-09-10  17:58
 * <p>@author : wjq
 */
public class HelloServiceHystrix implements UserService {

    @Override
    public String hello(String name) {
        return null;
    }
}
