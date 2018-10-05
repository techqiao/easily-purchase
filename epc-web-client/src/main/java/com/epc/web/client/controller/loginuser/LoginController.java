package com.epc.web.client.controller.loginuser;

import com.epc.common.Result;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.client.controller.loginuser.handle.ClientLoginUser;
import com.epc.web.client.controller.loginuser.handle.ClientModifyUser;
import com.epc.web.client.controller.loginuser.handle.ClientRegisterUser;
import com.epc.web.client.remoteApi.loginuser.ILoginUserClient;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "/public")
public class LoginController {

    @Autowired
    ILoginUserClient iLoginUserClient;

    @ApiOperation(value = "角色登录" ,notes="根据用户类型登录,运营商1,代理商2,供货商3,采购商4,专家5")
    @PostMapping(value = "/roleLogin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result login(@RequestBody ClientLoginUser user){
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user,loginUser);
        return iLoginUserClient.login(loginUser);
    }


    @ApiOperation(value = "角色登出" ,notes="根据用户类型登录,运营商1,代理商2,供货商3,采购商4专家5")
    @PostMapping(value = "/roleLoginOut",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> loginOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        CookieUtil.delLoginToken(httpServletRequest,httpServletResponse);
        RedisShardedPoolUtil.del(loginToken);
        return Result.success();
    }
    /**
     *@author :winlin
     *@Description :统一注册接口
     *@param:
     *@return:
     *@date:2018/10/1
     */
    @ApiOperation(value = "角色注册" ,notes="根据用户类型注册,运营商1,代理商2,供货商3,采购商4专家5")
    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> registerUser(@RequestBody ClientRegisterUser registerUser){
        RegisterUser user = new RegisterUser();
        BeanUtils.copyProperties(registerUser,user);
        return iLoginUserClient.registerUser(user);
    }
    /**
     *@author :winlin
     *@Description :修改密码
     *@param:
     *@return:
     *@date:2018/10/3
     */
    @ApiOperation(value = "用户修改密码" )
    @PostMapping(value = "/modifyPassword",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Boolean> modifyPassword(@RequestBody ClientModifyUser clientModifyUser){
        ModifyUser modifyUser = new ModifyUser();
        BeanUtils.copyProperties(clientModifyUser,modifyUser);
        return iLoginUserClient.modifyPassword(modifyUser);
    };
}
