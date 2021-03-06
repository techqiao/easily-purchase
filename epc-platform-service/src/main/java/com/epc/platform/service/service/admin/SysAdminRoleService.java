package com.epc.platform.service.service.admin;

import com.epc.administration.facade.admin.dto.QueryRoleInfo;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.Result;
import com.epc.platform.service.domain.admin.RoleWithSource;
import com.epc.platform.service.domain.admin.SysAdminRole;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 14:40
 * <p>@Author : luozhixin
 */
public interface SysAdminRoleService {

    /**
     * 查找用户角色
     * @param userName
     * @return
     */
    List<SysAdminRole> findUserRole(String userName);

    /**
     * 查询系统所有角色
     * @param
     * @return
     */
    List<SysAdminRole> findAllRole(QueryRoleInfo queryRoleInfo);


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
     */
    void addRole(RoleHandle role);


    /**
     * 删除角色
     * @param roleIds
     */
    void deleteRoles(String roleIds);

    /**
     * 编辑角色
     * @param updateRoleDTO
     */
    Result updateRole(UpdateRoleDTO updateRoleDTO);

}
