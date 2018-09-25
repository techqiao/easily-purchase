package com.epc.web.service.controller;

import com.epc.common.Result;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.service.service.IRoleLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/9/18
 */
@RestController
public class LoginController implements FacadeLoginUserService {

    @Autowired
    IRoleLoginService iRoleLoginService;
    @Override
    public Result<LoginUser> login(@RequestBody LoginUser user) {

       Result result= iRoleLoginService.login(user);
       if(result.getData()!=null){
           LoginUser loginUser = (LoginUser) result.getData();
           return Result.success("登陆成功",loginUser);
       }
        return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR);
    }
}
