package com.epc.platform.service.service.admin;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:32
 * <p>@Author : wjq
 */
public interface SysAdminUserRoleService {
    /**
     * 根据角色删除关联用户
     * @param roleIds
     */
    void deleteUserRolesByRoleId(String roleIds);

    /**
     * 删除角色关联用户
     * @param userIds
     */
    void deleteUserRolesByUserId(String userIds);
}
