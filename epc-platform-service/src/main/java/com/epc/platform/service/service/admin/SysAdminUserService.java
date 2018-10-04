package com.epc.platform.service.service.admin;

import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.Result;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.domain.admin.UserWithRole;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:44
 * <p>@Author : wjq
 */
public interface SysAdminUserService {

    /**
     * 系统后台登录
     * @param loginHandle
     * @return
     */
    Result<Map<String,Object>> login(LoginHandle loginHandle , String token);

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
     * 获取所有用户信息
     * @return
     */
    List<SysAdminUser> findUserWithDept(QueryUserDTO queryUserDTO);

    /**
     * 注册用户
     * @param userHandle
     */
    void registUser(UserHandle userHandle);

    /**
     * 新增用户
     * @param userHandle
     */
    void addUser(UserHandle userHandle);

    /**
     * 修改用户
     * @param userHandle
     */
    void updateUser(UserHandle userHandle);

    /**
     * 删除用户
     * @param userIds
     */
    void deleteUsers(String userIds);

    /**
     * 修改密码
     * @param userHandle
     */
    void updatePassword(UserHandle userHandle);


    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    SysAdminUser findUserDetail(Long userId);


    /**
     * 修改用户信息
     * @param userHandle
     */
    void updateUserDetail(UserHandle userHandle);
}
