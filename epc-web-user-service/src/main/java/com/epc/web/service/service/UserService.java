package com.epc.web.service.service;

import com.epc.web.service.domain.User;

/**
 * <p>Description : 用户接口
 * <p>Date : 2018-09-08 23:44
 * <p>@Author : wjq
 */
public interface UserService {

    /**
     * 获取用户信息
     * @param userId 用户id
     * @return
     */
    User getUserById(Long userId);

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    User login(String phone, String password);

    /**
     * 删除用户
     * @param userId 用户id
     * @return
     */
    Boolean deleteUserById(Long userId);

    /**
     * 更新用户
     * @param user 用户
     * @return
     */
    Boolean updateUserById(User user);

}
