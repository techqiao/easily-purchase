package com.epc.platform.service.service.admin;

import com.epc.platform.service.domain.admin.RoleWithSource;
import com.epc.platform.service.domain.admin.SysAdminRole;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 14:40
 * <p>@Author : wjq
 */
public interface SysAdminRoleService {

    List<SysAdminRole> findUserRole(String userName);

    /**
     * 查询系统所有角色
     * @param role
     * @return
     */
    List<SysAdminRole> findAllRole(SysAdminRole role);


    /**
     * 角色资源
     * @param roleId
     * @return
     */
    RoleWithSource findRoleWithResource(Long roleId);

    /**
     * 查询角色
     * @param roleName
     * @return
     */
    SysAdminRole findByName(String roleName);

    /**
     * 新增角色
     * @param role
     * @param resourceIds
     */
    void addRole(SysAdminRole role, Long[] resourceIds);


    /**
     * 删除角色
     * @param roleIds
     */
    void deleteRoles(String roleIds);

    /**
     * 编辑角色
     * @param role
     * @param resourceIds
     */
    void updateRole(SysAdminRole role, Long[] resourceIds);

}
