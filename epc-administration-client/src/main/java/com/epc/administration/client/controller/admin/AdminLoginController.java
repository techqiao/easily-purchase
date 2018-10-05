package com.epc.administration.client.controller.admin;

import com.epc.administration.client.controller.admin.handle.ClientUserLoginHandle;
import com.epc.administration.client.remoteapi.admin.AdminLoginClient;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 11:03
 * <p>@Author : luozhixin
 */
@Api(value = "系统后台登录 @罗志鑫",tags = {"系统后台登录"})
@RestController
@RequestMapping(value = "login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@SessionAttributes("session")
public class AdminLoginController {
    @Autowired
    private AdminLoginClient loginClient;

    /**用户登录
     * @param httpServletResponse
     * @param clientUserLoginHandle
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping(value = "login")
    public Result<Map<String,Object>> login(HttpServletResponse httpServletResponse ,
                                            @RequestBody ClientUserLoginHandle clientUserLoginHandle){
        LoginHandle loginHandle =  new LoginHandle();
        BeanUtils.copyProperties(clientUserLoginHandle,loginHandle);
        return loginClient.login(  httpServletResponse,loginHandle);
    }


    /**用户登出
     * @return
     */
    @ApiOperation(value = "用户登出", notes = "用户登出")
    @PostMapping(value = "/public/loginOut")
    @ResponseBody
    public Result<Boolean> loginOut(HttpServletRequest httpServletRequest,
                                     HttpServletResponse httpServletResponse) {
        return loginClient.loginOut(httpServletRequest, httpServletResponse);
    }
}
