package com.epc.operator.service.service.user;


import com.epc.operator.service.domain.user.User;

/**
 *
 * <p> To describe how this class works </p>
 *
 * @author junlee
 * @date {date}       // 创建时间
 */
public interface UserService {

    User findByName(String name);
}
