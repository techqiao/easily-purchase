package com.epc.user.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.user.service.domain.User;
import com.epc.user.service.domain.dto.QueryUserDTO;
import com.epc.user.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * <p>Description : 测试接口
 * <p>Date : 2018-09-09 00:03
 * <p>@Author : wjq
 */
@Api(value = "用户服务", description = "用户服务")
@RestController
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取信息用户", notes = "获取信息用户")
    @GetMapping(value = "/getUserInfo")
    public Result<User> getUserInfo(Long userId) {
        return Result.success(userService.getUserById(userId));
    }


    @ApiOperation(value = "获取信息列表", notes = "获取信息列表")
    @PostMapping(value = "getUserList")
    public Result<List<User>> getUserList(@RequestBody QueryUserDTO queryUserDTO) {
        return userService.getUserList(queryUserDTO);
    }


    @ApiOperation(value = "登录", notes = "登录")
    @GetMapping(value = "login")
    public Result<User> login(String username, String password, HttpSession session, HttpServletResponse httpServletResponse) {
        User user = userService.login(username, password);
        CookieUtil.writeLoginToken(httpServletResponse,session.getId());
        RedisShardedPoolUtil.setEx(session.getId(), JSONObject.toJSONString(user), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        return Result.success(user);
    }

    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    @GetMapping(value = "getUser")
    public Result<User> getUserInfo(HttpServletRequest httpServletRequest) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return Result.error("未登录");
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User user = JSONObject.parseObject(userJsonStr, User.class);
        return Result.success(user);
    }

    @ApiOperation(value = "登出", notes = "登出")
    @GetMapping(value = "loginOut")
    public Result<Boolean> loginOut(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        CookieUtil.delLoginToken(httpServletRequest,httpServletResponse);
        RedisShardedPoolUtil.del(loginToken);
        return Result.success();
    }
}
