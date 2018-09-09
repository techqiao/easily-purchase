package com.epc.user.service.service;

import com.epc.common.Result;
import com.epc.user.service.domain.User;
import com.epc.user.service.domain.dto.QueryUserDTO;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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


    /**
     * 获取用户列表
     * @return
     */
    Result<List<User>> getUserList(QueryUserDTO queryUserDTO);

}
