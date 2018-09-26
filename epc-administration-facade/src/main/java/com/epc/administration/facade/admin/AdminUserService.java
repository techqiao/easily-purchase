package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-9-10 16:55
 * <p>@author : wjq
 */
public interface AdminUserService {

    /**
     * 检查用户是否存在
     * @param username
     * @param oldusername
     * @return
     */
    @PostMapping(value = "checkUserName", consumes = "application/json; charset=UTF-8")
     Result checkUserName(@RequestParam("username") String username, @RequestParam("oldusername") String oldusername);

    /**
     * 获取用户详情
     * @param userId
     * @return
     */
    @PostMapping(value = "getUser" ,consumes = "application/json; charset=UTF-8")
     Result getUser(@RequestBody Long userId);

    /**
     * 获取用户信息 分页
     * @param request
     * @return
     */
    @PostMapping(value = "userList",consumes = "application/json; charset=UTF-8" )
     Result userList(@RequestBody QueryRequest request);

    /**
     * 注册
     * @param userHandle
     * @return
     */
    @PostMapping(value = "regist",consumes = "application/json; charset=UTF-8" )
    Result regist(@RequestBody UserHandle userHandle);

    /**
     * 新增用户
     * @param user
     * @param roles
     * @return
     */
    @PostMapping(value = "addUser" ,consumes = "application/json; charset=UTF-8")
    Result addUser(@RequestBody UserHandle user, @RequestParam("roles") Long[] roles);

    /**
     * 修改用户角色
     * @param user
     * @param rolesSelect
     * @return
     */
   @PostMapping(value = "updateUser" ,consumes = "application/json; charset=UTF-8")
    Result updateUser(@RequestBody UserHandle user, @RequestParam("rolesSelect") Long[] rolesSelect);

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @PostMapping(value = "deleteUsers" ,consumes = "application/json; charset=UTF-8")
    Result deleteUsers(@RequestBody String ids);

   /* *//**
     * 校验密码
     * @param password
     * @param httpServletRequest
     * @return
     */
    @PostMapping(value = "checkPassword" ,consumes = "application/json; charset=UTF-8")
    Result checkPassword(@RequestBody String password, @RequestParam("httpServletRequest") HttpServletRequest httpServletRequest);

    /**
     * 修改密码
     * @param newPassword
     * @param httpServletRequest
     * @return
     */
    @PostMapping(value = "updatePassword" ,consumes = "application/json; charset=UTF-8")
    Result updatePassword(@RequestBody String newPassword, @RequestParam("httpServletRequest") HttpServletRequest httpServletRequest);

    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    @PostMapping(value = "getUserDetail" ,consumes = "application/json; charset=UTF-8")
    Result getUserDetail(@RequestBody Long userId);

    /**
     * 更新用户信息
     * @param userHandle
     * @return
     */
    @PostMapping(value ="updateUserProfile" ,consumes = "application/json; charset=UTF-8")
     Result updateUserProfile(@RequestBody UserHandle userHandle);

}
