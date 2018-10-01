package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.dto.ClientQueryUserDTO;
import com.epc.administration.client.controller.admin.handle.ClientUserHandle;
import com.epc.administration.client.controller.admin.handle.InsertUserHandle;
import com.epc.administration.client.remoteapi.admin.SysAdminUserClient;
import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.UserHandle;
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
@Api(value = "系统用户 @罗志鑫",tags = {"系统用户服务"})
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminUserController {

    @Autowired
    private SysAdminUserClient sysAdminUserClient;

    /**检查用户是否可用
     * @param username
     * @return
     */
    @ApiOperation(value = "检查用户是否可用", notes = "检查用户是否可用")
    @GetMapping(value = "checkUserName")
    public Result<Boolean> checkUserName(@RequestParam("username") String username) {
        return sysAdminUserClient.checkUserName(username);
    }

    /**获取用户详情
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取用户详情", notes = "获取用户详情")
    @GetMapping(value = "getUser")
    public Result getUser(@RequestParam("userId") Long userId) {
        return sysAdminUserClient.getUser(userId);
    }

    /**获取用户信息 分页
     * @param clientQueryUserDTO
     * @return
     */
    @ApiOperation(value = "获取用户信息 分页", notes = "获取用户信息 分页")
    @PostMapping(value = "userList")
    public Result userList(@RequestBody ClientQueryUserDTO clientQueryUserDTO) {
        QueryUserDTO queryUserDTO = new QueryUserDTO();
        BeanUtils.copyProperties(clientQueryUserDTO,queryUserDTO);
        return sysAdminUserClient.userList(queryUserDTO);
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
     * @param insertUserHandle
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping(value = "addUser")
    public Result addUser(@RequestBody InsertUserHandle insertUserHandle ) {
        UserHandle userHandle = new UserHandle();
        BeanUtils.copyProperties(insertUserHandle,userHandle);
        return sysAdminUserClient.addUser(userHandle);
    }

    /**修改用户角色
     * @param clientUserHandle
     * @return
     */
    @ApiOperation(value = "修改用户角色", notes = "修改用户角色")
    @PostMapping(value = "updateUser")
    public Result updateUser(@RequestBody ClientUserHandle clientUserHandle) {
        UserHandle userHandle = new UserHandle();
        BeanUtils.copyProperties(clientUserHandle,userHandle);
        return sysAdminUserClient.updateUser(userHandle);
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
    @GetMapping(value = "getUserDetail")
    public Result getUserDetail(@RequestParam("userId") Long userId) {
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
