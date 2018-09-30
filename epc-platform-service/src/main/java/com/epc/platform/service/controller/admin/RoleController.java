package com.epc.platform.service.controller.admin;

import com.epc.administration.facade.admin.AdminRoleService;
import com.epc.administration.facade.admin.dto.QueryRoleInfo;
import com.epc.administration.facade.admin.dto.UpdateRoleDTO;
import com.epc.administration.facade.admin.handle.RoleHandle;
import com.epc.common.Result;
import com.epc.platform.service.domain.admin.SysAdminRole;
import com.epc.platform.service.service.admin.SysAdminRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @return
     */
    @Override
    public Result roleList(@RequestBody QueryRoleInfo queryRoleInfo) {
        PageHelper.startPage(queryRoleInfo.getPageNum(), queryRoleInfo.getPageSize());
        List<SysAdminRole> list = this.sysAdminRoleService.findAllRole(queryRoleInfo);
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
    /**校验角色是否存在
     * @param roleName
     * @return
     */
    @Override
    public Result checkRoleName(String roleName) {
        SysAdminRole byName = sysAdminRoleService.findByName(roleName);
        return Result.success(byName==null?true:false);
    }
    /**新增角色
     * @param role
     * @return
     */
    @Override
    public Result addRole(@RequestBody RoleHandle role) {
        try {
            sysAdminRoleService.addRole(role);
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
     * @return
     */
    @Override
    public Result updateRole(@RequestBody UpdateRoleDTO updateRoleDTO) {
        try {
            this.sysAdminRoleService.updateRole(updateRoleDTO);
            return Result.success("修改角色成功！");
        } catch (Exception e) {
            LOGGER.error("修改角色失败", e);
            return Result.error("修改角色失败，请联系网站管理员！");
        }
    }

}
