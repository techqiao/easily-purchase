package com.epc.administration.facade.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */

public interface UserService {

    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);

}
