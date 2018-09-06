package com.epc.operator.service.service.impl.user;


import com.epc.operator.service.domain.user.User;
import com.epc.operator.service.mapper.user.UserMapper;
import com.epc.operator.service.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByName(String name){

        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        userMapper.insert(uuid, 20);
        User u = userMapper.findByName("AAA");
        return u;
    }



}
