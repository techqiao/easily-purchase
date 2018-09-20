package com.epc.web.client.controller.loginuser;

import com.epc.common.Result;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.client.controller.loginuser.handle.ClientLoginUser;
import com.epc.web.client.remoteApi.loginuser.ILoginUserClient;
import com.epc.web.facade.loginuser.dto.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/9/18
 */

@Api(value = "角色登录服务",tags = {"角色登录服务"})
@RestController
public class LoginController {

    @Autowired
    ILoginUserClient iLoginUserClient;

    @ApiOperation(value = "角色登录" ,notes="根据用户类型登录,运营商1,代理商2,供货商3,采购商4")
    @PostMapping(value = "/roleLogin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result login(@RequestBody ClientLoginUser user){
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user,loginUser);
        return iLoginUserClient.login(loginUser);
    }


    @ApiOperation(value = "角色登出" ,notes="根据用户类型登录,运营商1,代理商2,供货商3,采购商4")
    @PostMapping(value = "/roleLoginOut",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> loginOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        CookieUtil.delLoginToken(httpServletRequest,httpServletResponse);
        RedisShardedPoolUtil.del(loginToken);
        return Result.success();
    }
}
