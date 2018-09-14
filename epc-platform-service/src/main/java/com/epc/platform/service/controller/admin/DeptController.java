package com.epc.platform.service.controller.admin;

import com.epc.common.Result;
import com.epc.common.util.Tree;
import com.epc.platform.service.domain.admin.SysAdminDept;
import com.epc.platform.service.service.admin.SysAdminDeptService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : 部门
 * <p>Date : 2018-09-13 19:25
 * <p>@Author : wjq
 */
@RestController
public class DeptController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private SysAdminDeptService sysAdminDeptService;

    //获取部门树
    public Result getDeptTree() {
        try {
            Tree<SysAdminDept> tree = this.sysAdminDeptService.getDeptTree();
            return Result.success(tree);
        } catch (Exception e) {
            LOGGER.error("获取部门树失败", e);
            return Result.error("获取部门树失败！");
        }
    }

    //获取部门列表
    public Result deptList(SysAdminDept dept) {
        try {
            List<SysAdminDept> deptList = this.sysAdminDeptService.findAllDepts(dept);
            return Result.success(deptList);
        } catch (Exception e) {
            LOGGER.error("获取部门列表失败", e);
            return Result.error("获取部门列表失败！");
        }
    }

    //获取部门信息
    public Result getDept(Long deptId) {
        try {
            SysAdminDept dept = this.sysAdminDeptService.findById(deptId);
            return Result.success(dept);
        } catch (Exception e) {
            LOGGER.error("获取部门信息失败", e);
            return Result.error("获取部门信息失败，请联系网站管理员！");
        }
    }

    //校验
    public boolean checkDeptName(String deptName, String oldDeptName) {
        if (StringUtils.isNotBlank(oldDeptName) && deptName.equalsIgnoreCase(oldDeptName)) {
            return true;
        }
        SysAdminDept result = this.sysAdminDeptService.findByName(deptName);
        return result == null;
    }


    //新增部门
    public Result addRole(SysAdminDept dept) {
        try {
            this.sysAdminDeptService.addDept(dept);
            return Result.success("新增部门成功！");
        } catch (Exception e) {
            LOGGER.error("新增部门失败", e);
            return Result.error("新增部门失败，请联系网站管理员！");
        }
    }

    //删除部门
    public Result deleteDepts(String ids) {
        try {
            this.sysAdminDeptService.deleteDepts(ids);
            return Result.success("删除部门成功！");
        } catch (Exception e) {
            LOGGER.error("删除部门失败", e);
            return Result.error("删除部门失败，请联系网站管理员！");
        }
    }

    //修改部门
    public Result updateRole(SysAdminDept dept) {
        try {
            this.sysAdminDeptService.updateDept(dept);
            return Result.success("修改部门成功！");
        } catch (Exception e) {
            LOGGER.error("修改部门失败", e);
            return Result.error("修改部门失败，请联系网站管理员！");
        }
    }


}
