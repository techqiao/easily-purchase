package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminRoleService;
import com.epc.administration.facade.admin.dto.QueryRoleInfo;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:52
 * <p>@Author : luozhixin
 */
public class AdminRoleHystrix implements AdminRoleService {
    @Override
    public Result roleList(QueryRoleInfo queryRoleInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result getRole(Long roleId) {
        return Result.hystrixError();
    }

    @Override
    public Result checkRoleName(String roleName) {
        return Result.hystrixError();
    }

    @Override
    public Result addRole(RoleHandle role) {
        return Result.hystrixError();
    }

    @Override
    public Result deleteRoles(String ids) {
        return Result.hystrixError();
    }

    @Override
    public Result updateRole(UpdateRoleDTO updateRoleDTO) {
        return Result.hystrixError();
    }
}
