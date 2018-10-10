package com.epc.administration.client.controller.admin;


import com.epc.administration.client.controller.admin.handle.ClientDeptHandle;
import com.epc.administration.client.remoteapi.admin.AdminDeptClient;
import com.epc.administration.facade.admin.handle.DeptHandle;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *  系统部门服务
 * @author luozhixin
 * @date 2018-9-14 20:19:31
 */
@Api(value = "系统部门服务 ",tags = {"系统部门服务"})
@RestController
@RequestMapping(value = "/dept", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminDeptController {

    @Autowired
    private AdminDeptClient deptClient;

    /**获取部门树
     * @return
     */
    @ApiOperation(value = "获取部门树", notes = "获取部门树")
    @PostMapping(value = "getDeptTree")
    public Result getDeptTree() {
        return  deptClient.getDeptTree();
    }

    /**获取部门列表
     * @param clientDeptHandle
     * @return
     */
    @ApiOperation(value = "获取部门列表", notes = "获取部门列表")
    @PostMapping(value = "deptList")
    public Result deptList(@RequestBody ClientDeptHandle clientDeptHandle) {
        DeptHandle deptHandle = new DeptHandle();
        BeanUtils.copyProperties(clientDeptHandle,deptHandle);
        return  deptClient.deptList(deptHandle);
    }

    /**获取部门信息
     * @param deptId
     * @return
     */
    @ApiOperation(value = "获取部门信息", notes = "获取部门信息")
    @GetMapping(value = "getDept")
    public Result getDept(@RequestParam("deptId") Long deptId) {
       return  deptClient.getDept(deptId);
    }

    /**校验
     * @param deptName
     * @return
     */
    @ApiOperation(value = "校验部门名是否重复 true不重复可以用", notes = "校验部门名是否以有")
    @GetMapping(value = "checkDeptName")
    public Result checkDeptName(@RequestParam("deptName") String deptName) {
      return  deptClient.checkDeptName(deptName);
    }

    /**新增部门
     * @param clientDeptHandle
     * @return
     */
    @ApiOperation(value = "新增部门", notes = "新增部门")
    @PostMapping(value = "addDept")
    public Result addDept(@RequestBody ClientDeptHandle clientDeptHandle) {
        DeptHandle deptHandle = new DeptHandle();
        BeanUtils.copyProperties(clientDeptHandle,deptHandle);
       return deptClient.addDept(deptHandle);
    }

    /**删除部门
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除部门", notes = "删除部门")
    @PostMapping(value = "deleteDepts")
    public Result deleteDepts(@RequestBody String ids) {
       return  deptClient.deleteDepts(ids);
    }

    /**修改部门
     * @param clientDeptHandle
     * @return
     */
    @ApiOperation(value = "修改部门", notes = "修改部门")
    @PostMapping(value = "updateDept")
    public Result updateDept(@RequestBody ClientDeptHandle clientDeptHandle) {
        DeptHandle deptHandle = new DeptHandle();
        BeanUtils.copyProperties(clientDeptHandle,deptHandle);
        return  deptClient.updateDepts(deptHandle);
    }



}
