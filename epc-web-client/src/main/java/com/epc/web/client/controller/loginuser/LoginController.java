package com.epc.web.client.controller.loginuser;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.loginuser.ILoginUserClient;
import com.epc.web.facade.loginuser.dto.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class LoginController {

    @Autowired
    ILoginUserClient iLoginUserClient;
    @ApiOperation(value = "角色登录" ,notes="根据用户类型登录,运营商1,代理商2,供货商3,采购商4")
    @RequestMapping(value = "/rolelogin", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result login(@RequestBody LoginUser user, HttpServletRequest request, HttpServletResponse response){
        return iLoginUserClient.login(user);
    }
}
