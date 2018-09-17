package com.epc.platform.service.controller.admin;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 11:29
 * <p>@Author : wjq
 */
@RestController
public class RoleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private SysAdminRoleService sysAdminRoleService;

    //获取角色信息
    @RequestMapping("role/list")
    @ResponseBody
    public Map<String, Object> roleList(QueryRequest request, SysAdminRole role) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<SysAdminRole> list = this.sysAdminRoleService.findAllRole(role);
        PageInfo<SysAdminRole> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    //获取角色信息
    @RequestMapping("role/getRole")
    @ResponseBody
    public Result getRole(Long roleId) {
        try {
            SysAdminRole role = this.sysAdminRoleService.findRoleWithResource(roleId);
            return Result.success(role);
        } catch (Exception e) {
            LOGGER.error("获取角色信息失败", e);
            return Result.error("获取角色信息失败，请联系网站管理员！");
        }
    }

    //检查角色名称
    public boolean checkRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
            return true;
        }
        SysAdminRole result = this.sysAdminRoleService.findByName(roleName);
        return result == null;
    }

    //新增角色
    public Result addRole(SysAdminRole role, Long[] resourceIds) {
        try {
            this.sysAdminRoleService.addRole(role, resourceIds);
            return Result.success("新增角色成功！");
        } catch (Exception e) {
            LOGGER.error("新增角色失败", e);
            return Result.error("新增角色失败，请联系网站管理员！");
        }
    }

    //删除角色
    public Result deleteRoles(String ids) {
        try {
            this.sysAdminRoleService.deleteRoles(ids);
            return Result.success("删除角色成功！");
        } catch (Exception e) {
            LOGGER.error("删除角色失败", e);
            return Result.error("删除角色失败，请联系网站管理员！");
        }
    }

    //修改角色
    public Result updateRole(SysAdminRole role, Long[] menuId) {
        try {
            this.sysAdminRoleService.updateRole(role, menuId);
            return Result.success("修改角色成功！");
        } catch (Exception e) {
            LOGGER.error("修改角色失败", e);
            return Result.error("修改角色失败，请联系网站管理员！");
        }
    }

}
