package com.epc.user.service.service;

import com.epc.user.service.common.BaseResult;
import com.epc.user.service.domain.User;
import com.epc.user.service.domain.dto.QueryUserDTO;

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
    User getUserById(Integer userId);

    /**
     * 删除用户
     * @param userId 用户id
     * @return
     */
    Boolean deleteUserById(Integer userId);

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
    BaseResult<List<User>> getUserList(QueryUserDTO queryUserDTO);

}
