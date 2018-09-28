package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.handle.ClientUserHandle;
import com.epc.administration.client.remoteapi.admin.SysAdminUserClient;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:55
 * <p>@Author : luozhixin
 */
@Api(value = "系统用户",tags = {"系统用户服务"})
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminUserController {

    @Autowired
    private SysAdminUserClient sysAdminUserClient;

    /**检查用户是否存在
     * @param username
     * @param oldusername
     * @return
     */
    @ApiOperation(value = "检查用户是否存在", notes = "检查用户是否存在")
    @PostMapping(value = "checkUserName")
    public Result checkUserName(@RequestParam("username") String username, @RequestParam("oldusername") String oldusername) {
        return sysAdminUserClient.checkUserName(username, oldusername);
    }

    /**获取用户详情
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取用户详情", notes = "获取用户详情")
    @PostMapping(value = "getUser")
    public Result getUser(@RequestBody Long userId) {
        return sysAdminUserClient.getUser(userId);
    }

    /**获取用户信息 分页
     * @param request
     * @return
     */
    @ApiOperation(value = "获取用户信息 分页", notes = "获取用户信息 分页")
    @PostMapping(value = "userList")
    public Result userList(@RequestBody QueryRequest request) {
        return sysAdminUserClient.userList(request);
    }

    /**注冊
     * @param clientUserHandle
     * @return
     */
    @ApiOperation(value = "注冊", notes = "注冊")
    @PostMapping(value = "regist")
    public Result regist(@RequestBody ClientUserHandle clientUserHandle) {
        UserHandle userHandle = new UserHandle();
        BeanUtils.copyProperties(clientUserHandle,userHandle);
        return sysAdminUserClient.regist(userHandle);
    }

    /**新增用户
     * @param clientUserHandle
     * @param roles
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping(value = "addUser")
    public Result addUser(@RequestBody ClientUserHandle clientUserHandle, @RequestParam("roles") Long[] roles) {
        UserHandle userHandle = new UserHandle();
        BeanUtils.copyProperties(clientUserHandle,userHandle);
        return sysAdminUserClient.addUser(userHandle, roles);
    }

    /**修改用户角色
     * @param clientUserHandle
     * @param rolesSelect
     * @return
     */
    @ApiOperation(value = "修改用户角色", notes = "修改用户角色")
    @PostMapping(value = "updateUser")
    public Result updateUser(@RequestBody ClientUserHandle clientUserHandle, @RequestParam("rolesSelect") Long[] rolesSelect) {
        UserHandle userHandle = new UserHandle();
        BeanUtils.copyProperties(clientUserHandle,userHandle);
        return sysAdminUserClient.updateUser(userHandle, rolesSelect);
    }

    /**删除用户
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @PostMapping(value = "deleteUsers")
    public Result deleteUsers(@RequestBody String ids) {
        return sysAdminUserClient.deleteUsers(ids);
    }

    /**校验密码
     * @param password
     * @param httpServletRequest
     * @return
     */
    @ApiOperation(value = "校验密码", notes = "校验密码")
    @PostMapping(value = "checkPassword")
    public Result checkPassword(@RequestBody String password, @RequestParam("httpServletRequest") HttpServletRequest httpServletRequest) {
        return sysAdminUserClient.checkPassword(password, httpServletRequest);
    }

    /**修改密码
     * @param newPassword
     * @param httpServletRequest
     * @return
     */
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PostMapping(value = "updatePassword")
    public Result updatePassword(@RequestBody String newPassword, @RequestParam("httpServletRequest") HttpServletRequest httpServletRequest) {
        return sysAdminUserClient.updatePassword(newPassword, httpServletRequest);
    }

    /**获取用户基本信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取用户基本信息", notes = "获取用户基本信息")
    @PostMapping(value = "getUserDetail")
    public Result getUserDetail(@RequestBody Long userId) {
        return sysAdminUserClient.getUserDetail(userId);
    }

    /**更新用户信息
     * @param clientUserHandle
     * @return
     */
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping(value = "updateUserProfile")
    public Result updateUserProfile(@RequestBody ClientUserHandle clientUserHandle){
        UserHandle userHandle = new UserHandle();
        BeanUtils.copyProperties(clientUserHandle,userHandle);
        return sysAdminUserClient.updateUserProfile(userHandle);
    }
}