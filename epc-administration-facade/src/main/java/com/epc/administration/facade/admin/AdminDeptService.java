package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.handle.DeptHandle;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:37
 * <p>@Author : luozhixin
 */
public interface AdminDeptService {

    /**获取部门树
     * @return
     */
    @PostMapping(value ="getDeptTree", consumes = "application/json; charset=UTF-8" )
     Result getDeptTree() ;

    /**获取部门列表
     * @param dept
     * @return
     */
    @PostMapping(value ="deptList" , consumes = "application/json; charset=UTF-8")
     Result deptList(DeptHandle dept);

    /**获取部门信息
     * @param deptId
     * @return
     */
    @PostMapping(value ="getDept" , consumes = "application/json; charset=UTF-8")
     Result getDept(@RequestParam(value = "deptId") Long deptId) ;

    /**校验
     * @param deptName
     * @param oldDeptName
     * @return
     */
    @PostMapping(value ="checkDeptName" , consumes = "application/json; charset=UTF-8")
     Result checkDeptName(@RequestParam("deptName") String deptName, @RequestParam("oldDeptName") String oldDeptName);

    /**新增部门
     * @param deptHandle
     * @return
     */
    @PostMapping(value ="addDept" , consumes = "application/json; charset=UTF-8")
     Result addDept(@RequestBody DeptHandle deptHandle);

    /**删除部门
     * @param ids
     * @return
     */
    @PostMapping(value ="deleteDepts" , consumes = "application/json; charset=UTF-8")
     Result deleteDepts(@RequestBody String ids);

    /**修改部门
     * @param dept
     * @return
     */
    @PostMapping(value ="updateDepts" , consumes = "application/json; charset=UTF-8")
    Result updateDepts(@RequestBody DeptHandle dept);

}
