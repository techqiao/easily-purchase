package com.epc.platform.service.controller.admin;

import com.epc.administration.facade.admin.AdminRoleService;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.platform.service.domain.admin.SysAdminRole;
import com.epc.platform.service.service.admin.SysAdminRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色服务
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 11:29
 * <p>@Author : wjq
 */
@RestController
public class RoleController extends BaseController implements AdminRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private SysAdminRoleService sysAdminRoleService;

    /**获取所有角色信息
     * @param request
     * @return
     */
    @Override
    public Result roleList(@RequestBody QueryRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<SysAdminRole> list = this.sysAdminRoleService.findAllRole();
        PageInfo<SysAdminRole> pageInfo = new PageInfo<>(list);
        return Result.success(getDataTable(pageInfo)) ;
    }
    /**获取角色信息
     * @param roleId
     * @return
     */
    @Override
    public Result getRole(@RequestBody Long roleId) {
        try {
            SysAdminRole role = this.sysAdminRoleService.findRoleWithResource(roleId);
            return Result.success(role);
        } catch (Exception e) {
            LOGGER.error("获取角色信息失败", e);
            return Result.error("获取角色信息失败，请联系网站管理员！");
        }
    }
    /**根据角色名查询角色信息
     * @param roleName
     * @param oldRoleName
     * @return
     */
    @Override
    public Result checkRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
            return Result.success();
        }
        SysAdminRole result = this.sysAdminRoleService.findByName(roleName);
        return Result.success(result);
    }
    /**新增角色
     * @param role
     * @param resourceIds
     * @return
     */
    @Override
    public Result addRole(@RequestBody RoleHandle role, @RequestParam("resourceIds") Long[] resourceIds) {
        try {
            sysAdminRoleService.addRole(role, resourceIds);
            return Result.success("新增角色成功！");
        } catch (Exception e) {
            LOGGER.error("新增角色失败", e);
            return Result.error("新增角色失败，请联系网站管理员！");
        }
    }
    /**删除角色
     * @param ids
     * @return
     */
    @Override
    public Result deleteRoles(@RequestBody String ids) {
        try {
            this.sysAdminRoleService.deleteRoles(ids);
            return Result.success("删除角色成功！");
        } catch (Exception e) {
            LOGGER.error("删除角色失败", e);
            return Result.error("删除角色失败，请联系网站管理员！");
        }
    }
    /**修改角色
     * @param updateRoleDTO
     * @param resourceIds
     * @return
     */
    @Override
    public Result updateRole(@RequestBody UpdateRoleDTO updateRoleDTO, Long[] resourceIds) {
        try {
            this.sysAdminRoleService.updateRole(updateRoleDTO, resourceIds);
            return Result.success("修改角色成功！");
        } catch (Exception e) {
            LOGGER.error("修改角色失败", e);
            return Result.error("修改角色失败，请联系网站管理员！");
        }
    }

}
