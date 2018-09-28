package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminDeptService;
import com.epc.administration.facade.admin.handle.DeptHandle;
import com.epc.common.Result;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:49
 * <p>@Author : luozhixin
 */
public class AdminDeptHystrix implements AdminDeptService {
    @Override
    public Result getDeptTree() {
        return Result.hystrixError();
    }

    @Override
    public Result deptList(DeptHandle dept) {
        return Result.hystrixError();
    }

    @Override
    public Result getDept(Long deptId) {
        return Result.hystrixError();
    }

    @Override
    public Result checkDeptName(String deptName, String oldDeptName) {
        return Result.hystrixError();
    }

    @Override
    public Result addDept(DeptHandle dept) {
        return Result.hystrixError();
    }

    @Override
    public Result deleteDepts(String ids) {
        return Result.hystrixError();
    }

    @Override
    public Result updateDepts(DeptHandle dept) {
        return Result.hystrixError();
    }

}
