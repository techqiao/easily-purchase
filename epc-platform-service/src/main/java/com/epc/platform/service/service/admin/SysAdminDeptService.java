package com.epc.platform.service.service.admin;

import com.epc.administration.facade.admin.handle.DeptHandle;
import com.epc.common.util.Tree;
import com.epc.platform.service.domain.admin.SysAdminDept;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 19:27
 * <p>@Author : luozhixin
 */
public interface SysAdminDeptService {

    /**
     * 获取部门
     * @return
     */
    Tree<SysAdminDept> getDeptTree();


    /**
     * 查找所有部门
     * @param dept
     * @return
     */
    List<SysAdminDept> findAllDepts(DeptHandle dept);

    /**
     * 根据ID查找部门
     * @param deptId
     * @return
     */
    SysAdminDept findById(Long deptId);

    /**
     * 根据name查找部门
     * @param deptName
     * @return
     */
    SysAdminDept findByName(String deptName);


    /**
     * 新增部门
     * @param dept
     */
    void addDept(DeptHandle dept);

    /**
     * 删除部门
     * @param deptIds
     */
    void deleteDepts(String deptIds);

    /**
     * 修改部门
     * @param dept
     */
    void updateDept(DeptHandle dept);
}
