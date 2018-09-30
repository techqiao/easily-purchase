package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.dto.ClientQueryRoleInfo;
import com.epc.administration.client.controller.admin.dto.ClientUpdateRoleDTO;
import com.epc.administration.client.controller.admin.handle.ClientRoleHandle;
import com.epc.administration.client.remoteapi.admin.AdminRoleClient;
import com.epc.administration.facade.admin.dto.QueryRoleInfo;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
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
     * @return
     */
    @ApiOperation(value = "获取所有角色信息，分页展示", notes = "获取所有角色信息 分页展示")
    @PostMapping(value = "roleList")
    public Result roleList(@RequestBody ClientQueryRoleInfo clientQueryRoleInfo) {
        QueryRoleInfo queryRoleInfo = new QueryRoleInfo();
        BeanUtils.copyProperties(clientQueryRoleInfo, queryRoleInfo);
        return sysAdminRoleClient.roleList(queryRoleInfo);
    }

    /**根据id获取角色信息
     * @param roleId
     * @return
     */
    @ApiOperation(value = "根据id获取角色信息", notes = "根据id获取角色信息")
    @PostMapping(value = "getRole")
    public Result getRole(@RequestBody Long roleId) {
        return sysAdminRoleClient.getRole(roleId);
    }

    /**校验角色是否存在
     * @param roleName
     * @return
     */
    @ApiOperation(value = "校验角色名是否存在 存在false ，不存在true", notes = "校验角色名是否可用")
    @GetMapping(value = "checkRoleName")
    public Result checkRoleName(@RequestParam("roleName") String roleName) {
        return sysAdminRoleClient.checkRoleName(roleName);
    }

    /**新增角色
     * @param clientRoleHandle
     * @return
     */
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @PostMapping(value = "addRole")
    public Result addRole(@RequestBody ClientRoleHandle clientRoleHandle) {
        RoleHandle roleHandle = new RoleHandle();
        BeanUtils.copyProperties(clientRoleHandle,roleHandle);
        return sysAdminRoleClient.addRole(roleHandle);
    }

    /**批量删除角色
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除角色", notes = "批量删除角色")
    @PostMapping(value = "deleteRoles")
    public Result deleteRoles(@RequestBody String ids) {
        return sysAdminRoleClient.deleteRoles(ids);
    }

    /**修改角色
     * @param
     * @return
     */
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @PostMapping(value = "updateRole")
    public Result updateRole(@RequestBody ClientUpdateRoleDTO clientUpdateRoleDTO) {
        UpdateRoleDTO updateRoleDTO = new UpdateRoleDTO();
        BeanUtils.copyProperties(clientUpdateRoleDTO,updateRoleDTO);
        return sysAdminRoleClient.updateRole(updateRoleDTO);
    }
}
