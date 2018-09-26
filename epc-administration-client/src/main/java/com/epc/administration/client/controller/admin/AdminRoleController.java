package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.handle.ClientRoleHandle;
import com.epc.administration.client.remoteapi.admin.AdminRoleClient;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 09:53
 * <p>@Author : luozhixin
 */
@Api(value = "系统角色",tags = {"系统角色服务"})
@RestController
@RequestMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminRoleController {

    @Autowired
    private AdminRoleClient sysAdminRoleClient;

    /**获取所有角色信息
     * @param request
     * @return
     */
    @ApiOperation(value = "获取角色信息", notes = "获取角色信息")
    @PostMapping(value = "roleList")
    public Result roleList(@RequestBody QueryRequest request) {
        return sysAdminRoleClient.roleList(request);
    }

    /**获取角色信息
     * @param roleId
     * @return
     */
    @ApiOperation(value = "获取角色信息", notes = "获取角色信息")
    @PostMapping(value = "getRole")
    public Result getRole(@RequestBody Long roleId) {
        return sysAdminRoleClient.getRole(roleId);
    }

    /**根据角色名查询角色信息
     * @param roleName
     * @param oldRoleName
     * @return
     */
    @ApiOperation(value = "根据角色名查询角色信息", notes = "根据角色名查询角色信息")
    @PostMapping(value = "checkRoleName")
    public Result checkRoleName(@RequestParam("roleName") String roleName, @RequestParam("oldRoleName") String oldRoleName) {
        return sysAdminRoleClient.checkRoleName(roleName, oldRoleName);
    }

    /**新增角色
     * @param clientRoleHandle
     * @param resourceIds
     * @return
     */
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @PostMapping(value = "addRole")
    public Result addRole(@RequestBody ClientRoleHandle clientRoleHandle, Long[] resourceIds) {
        RoleHandle roleHandle = new RoleHandle();
        BeanUtils.copyProperties(clientRoleHandle,roleHandle);
        return sysAdminRoleClient.addRole(roleHandle, resourceIds);
    }

    /**删除角色
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除角色", notes = "删除角色")
    @PostMapping(value = "deleteRoles")
    public Result deleteRoles(@RequestBody String ids) {
        return sysAdminRoleClient.deleteRoles(ids);
    }

    /**修改角色
     * @param
     * @param resourceIds
     * @return
     */
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @PostMapping(value = "updateRole")
    public Result updateRole(@RequestBody ClientRoleHandle clientRoleHandle, Long[] resourceIds) {
        UpdateRoleDTO updateRoleDTO = new UpdateRoleDTO();
        BeanUtils.copyProperties(clientRoleHandle,updateRoleDTO);
        return sysAdminRoleClient.updateRole(updateRoleDTO, resourceIds);
    }
}
