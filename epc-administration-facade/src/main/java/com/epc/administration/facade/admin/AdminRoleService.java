package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.dto.QueryRoleInfo;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:41
 * <p>@Author : luozhixin
 */
public interface AdminRoleService {
    /**获取角色信息
     * @return
     */
    @RequestMapping("role/list")
    Result roleList(@RequestBody QueryRoleInfo queryRoleInfo);

    /**获取角色信息
     * @param roleId
     * @return
     */
    @RequestMapping("role/getRole")
    Result getRole(Long roleId);

    /**根据角色名查询角色信息
     * @param roleName
     * @return
     */
    @GetMapping("role/checkRoleName")
    Result checkRoleName(@RequestParam("roleName") String roleName);

    /**新增角色
     * @param role
     * @return
     */
    @RequestMapping("role/addRole")
    Result addRole(@RequestBody RoleHandle role);

    /**删除角色
     * @param ids
     * @return
     */
    @RequestMapping("role/deleteRoles")
    Result deleteRoles(@RequestBody String ids);

    /**修改角色
     * @param updateRoleDTO
     * @return
     */
    @RequestMapping("role/updateRole")
    Result updateRole(@RequestBody UpdateRoleDTO updateRoleDTO);

}
