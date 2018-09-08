package com.epc.user.service.controller;

import com.epc.user.service.common.BaseResult;
import com.epc.user.service.domain.User;
import com.epc.user.service.domain.dto.QueryUserDTO;
import com.epc.user.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * <p>Description : easily-purchase
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
    public BaseResult<User>  getUserInfo(Integer userId) {
        BaseResult result = new BaseResult();
        result.setData(userService.getUserById(userId));
        return result;
    }


    @ApiOperation(value = "获取信息列表", notes = "获取信息列表")
    @PostMapping(value = "getUserList")
    public BaseResult<List<User>> getUserList(@RequestBody QueryUserDTO queryUserDTO) {
        return userService.getUserList(queryUserDTO);
    }


}
