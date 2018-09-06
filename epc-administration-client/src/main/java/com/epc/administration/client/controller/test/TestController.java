package com.epc.administration.client.controller.test;

import com.epc.administration.client.remoteapi.test.HelloServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */
@RestController
public class TestController {


    @Autowired
    private HelloServiceClient helloServiceClient;


    @GetMapping("/test")
    public String test(String name) {
        System.out.println("******* TestController ********"  + Long.valueOf(new Date().getTime()));

        return helloServiceClient.hello(name);
    }

}