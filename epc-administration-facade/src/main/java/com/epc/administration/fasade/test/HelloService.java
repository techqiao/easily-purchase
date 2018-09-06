package com.epc.administration.fasade.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */

public interface HelloService {

    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}
