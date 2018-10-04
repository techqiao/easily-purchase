package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.dto.QueryUserDTO;
import com.epc.administration.facade.admin.handle.UserHandle;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @return
     */
    @GetMapping(value = "checkUserName")
     Result<Boolean> checkUserName(@RequestParam("username") String username);

    /**
     * 获取用户详情
     * @param userId
     * @return
     */
    @GetMapping(value = "getUser")
     Result getUser(@RequestBody Long userId);

    /**
     * 获取用户信息 分页
     * @param queryUserDTO
     * @return
     */
    @PostMapping(value = "userList",consumes = "application/json; charset=UTF-8" )
     Result userList(@RequestBody QueryUserDTO queryUserDTO);

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
     * @return
     */
    @PostMapping(value = "addUser" ,consumes = "application/json; charset=UTF-8")
    Result addUser(@RequestBody UserHandle user);

    /**
     * 修改用户角色
     * @param user
     * @return
     */
   @PostMapping(value = "updateUser" ,consumes = "application/json; charset=UTF-8")
    Result updateUser(@RequestBody UserHandle user);

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
     * @param userHandle
     * @return
     */
    @PostMapping(value = "updatePassword" ,consumes = "application/json; charset=UTF-8")
    Result updatePassword(@RequestBody UserHandle userHandle);

    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    @GetMapping(value = "getUserDetail")
    Result getUserDetail(@RequestBody Long userId);

    /**
     * 更新用户信息
     * @param userHandle
     * @return
     */
    @PostMapping(value ="updateUserProfile" ,consumes = "application/json; charset=UTF-8")
     Result updateUserProfile(@RequestBody UserHandle userHandle);

}
