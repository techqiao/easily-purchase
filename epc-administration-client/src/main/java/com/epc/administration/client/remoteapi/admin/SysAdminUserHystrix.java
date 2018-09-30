package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminUserService;
import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:53
 * <p>@Author : luozhixin
 */
public class SysAdminUserHystrix implements AdminUserService {
    @Override
    public Result checkUserName(String username, String oldusername) {
        return Result.hystrixError();
    }

    @Override
    public Result getUser(Long userId) {
        return Result.hystrixError();
    }

    @Override
    public Result userList(QueryUserDTO queryUserDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result regist(UserHandle userHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result addUser(UserHandle user) {
        return Result.hystrixError();
    }

    @Override
    public Result updateUser(UserHandle user) {
        return Result.hystrixError();
    }

    @Override
    public Result deleteUsers(String ids) {
        return Result.hystrixError();
    }

    @Override
    public Result checkPassword(String password, HttpServletRequest httpServletRequest) {
        return Result.hystrixError();
    }

    @Override
    public Result updatePassword(String newPassword, HttpServletRequest httpServletRequest) {
        return Result.hystrixError();
    }

    @Override
    public Result getUserDetail(Long userId) {
        return Result.hystrixError();
    }

    @Override
    public Result updateUserProfile(UserHandle userHandle) {
        return Result.hystrixError();
    }
}
