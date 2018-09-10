package com.epc.platform.service.controller.user;

import com.epc.administration.facade.user.HelloService;
import com.epc.platform.service.domain.user.User;
import com.epc.platform.service.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HelloController implements HelloService {

    @Autowired
    private UserService userService;

        @Override
        public String hello(String name) {
            System.out.println("******* HelloController   service ********"  + Long.valueOf(new Date().getTime()));
            User user=  userService.findByName("AAAA");
            return "hello " + user.getName()  + "---age" + user.getAge();
        }

}
