package com.epc.platform.service.service.admin;

import com.epc.common.util.Tree;
import com.epc.platform.service.domain.admin.SysAdminDept;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13 19:27
 * <p>@Author : wjq
 */
public interface SysAdminDeptService {

    Tree<SysAdminDept> getDeptTree();


    List<SysAdminDept> findAllDepts(SysAdminDept dept);


    SysAdminDept findById(Long deptId);


    SysAdminDept findByName(String deptName);


    void addDept(SysAdminDept dept);

    void deleteDepts(String deptIds);

    void updateDept(SysAdminDept dept);
}
