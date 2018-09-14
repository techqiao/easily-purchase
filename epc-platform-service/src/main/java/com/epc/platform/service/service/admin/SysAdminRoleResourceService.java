package com.epc.platform.service.service.admin;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 16:28
 * <p>@Author : wjq
 */
public interface SysAdminRoleResourceService {

    /**
     * 根据角色id删除角色关联资源
     * @param roleIds
     */
    void deleteRoleResourceByRoleId(String roleIds);
}
