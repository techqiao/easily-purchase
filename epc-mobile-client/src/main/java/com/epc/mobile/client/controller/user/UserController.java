package com.epc.mobile.client.controller.user;

import com.epc.mobile.client.remoteapi.user.HelloServiceClient;
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
public class UserController {


    @Autowired
    private HelloServiceClient helloServiceClient;


    @GetMapping("/user")
    public String user(String name) {
        System.out.println("******* TestController ********"  + Long.valueOf(new Date().getTime()));

        return helloServiceClient.hello(name);
    }

}