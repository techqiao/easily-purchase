package com.epc.mobile.client.controller.loginuser;

import com.epc.common.Result;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.mobile.client.controller.loginuser.dto.ClientLoginer;
import com.epc.mobile.client.controller.loginuser.dto.ClientModifyUser;
import com.epc.mobile.client.controller.loginuser.dto.ClientRegisterUser;
import com.epc.mobile.client.remoteApi.ILoginUserClient;
import com.epc.web.facade.loginuser.dto.Loginer;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Api(value = "角色登录服务", tags = {"角色登录服务"})
@RestController
@RequestMapping(value = "/public")
public class LoginController {

    @Autowired
    ILoginUserClient iLoginUserClient;

    @ApiOperation(value = "角色登录", notes = "根据用户类型登录,运营商1,代理商2,供货商3,采购商4,专家5")
    @PostMapping(value = "/roleLogin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result login(@RequestBody ClientLoginer user) {
        Loginer loginer = new Loginer();
        BeanUtils.copyProperties(user, loginer);
        return iLoginUserClient.login(loginer);
    }


    @ApiOperation(value = "角色登出", notes = "根据用户类型登录,运营商1,代理商2,供货商3,采购商4专家5")
    @PostMapping(value = "/roleLoginOut", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> loginOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        CookieUtil.delLoginToken(httpServletRequest, httpServletResponse);
        RedisShardedPoolUtil.del(loginToken);
        return Result.success();
    }

    /**
     * @author :winlin
     * @Description :统一注册接口
     * @param:
     * @return:
     * @date:2018/10/1
     */
    @ApiOperation(value = "角色注册", notes = "根据用户类型注册,运营商1,代理商2,供货商3,采购商4专家5")
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> registerUser(@RequestBody ClientRegisterUser registerUser) {
        RegisterUser user = new RegisterUser();
        BeanUtils.copyProperties(registerUser, user);
        return iLoginUserClient.registerUser(user);
    }

    /**
     * @author :winlin
     * @Description :修改密码
     * @param:
     * @return:
     * @date:2018/10/3
     */
    @ApiOperation(value = "用户修改密码")
    @PostMapping(value = "/modifyPassword", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result<Boolean> modifyPassword(@RequestBody ClientModifyUser clientModifyUser) {
        ModifyUser modifyUser = new ModifyUser();
        BeanUtils.copyProperties(clientModifyUser, modifyUser);
        return iLoginUserClient.modifyPassword(modifyUser);
    }

    ;

    /**
     * @author :winlin
     * @Description :发送短信验证码
     * @date:2018/10/11
     */
    @ApiOperation(value = "发送短信验证码")
    @GetMapping(path = "retrieveVerifyCode/{cellphone}")
    Result retrieveVerifyCode(@PathVariable("cellphone") String cellphone) {
        String cellphones = cellphone.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", "");
        return iLoginUserClient.retrieveVerifyCode(cellphone);
    }
}



