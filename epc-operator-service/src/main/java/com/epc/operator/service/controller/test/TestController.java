package com.epc.operator.service.controller.test;

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

    public void test(String name) {
        System.out.println("******* HelloController   service ********"  + Long.valueOf(new Date().getTime()));
    }

}
