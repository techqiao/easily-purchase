package com.epc.platform.service.service.admin;

import com.epc.common.Result;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.domain.admin.UserWithRole;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:44
 * <p>@Author : wjq
 */
public interface SysAdminUserService {

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    Result<SysAdminUser> login(String phone, String password);

    /**
     * 查询用户信息
     * @param userName
     * @param phone
     * @return
     */
    SysAdminUser findByName(String userName, String phone);

    /**
     * 查询用户所属角色
     * @param userId
     * @return
     */
    UserWithRole findById(Long userId);


    /**
     * 获取用户信息
     * @param user
     * @return
     */
    List<SysAdminUser> findUserWithDept(SysAdminUser user);

    /**
     * 注册用户
     * @param user
     */
    void registUser(SysAdminUser user);

    /**
     * 新增用户
     * @param user
     * @param roles
     */
    void addUser(SysAdminUser user, Long[] roles);

    /**
     * 修改用户
     * @param user
     * @param roles
     */
    void updateUser(SysAdminUser user, Long[] roles);

    /**
     * 删除用户
     * @param userIds
     */
    void deleteUsers(String userIds);

    /**
     * 修改密码
     * @param password
     */
    void updatePassword(SysAdminUser sysAdminUser,String password);


    /**
     * 获取用户信息
     * @param user
     * @return
     */
    SysAdminUser findUserDetail(SysAdminUser user);


    /**
     * 修改用户信息
     * @param user
     */
    void updateUserDetail(SysAdminUser user);
}
