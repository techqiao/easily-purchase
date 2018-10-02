package com.epc.web.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import com.epc.web.service.service.IRoleLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public Result login(@RequestBody LoginUser user) {

       Result result= iRoleLoginService.login(user);
       if(result.getData()!=null){
           LoginUser loginUser = (LoginUser) result.getData();
           String token = "EPC_PRIVATE_"+UUID.randomUUID().toString().replace("-","");
           Map<String,Object> resultMap = new HashMap<String,Object>();
           resultMap.put("user",result);
           resultMap.put("epc-token",token);
           RedisShardedPoolUtil.setEx(token, JSONObject.toJSONString(loginUser), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
           return Result.success("登陆成功",resultMap);
       }
        return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR);
    }

    @Override
    public Result<Boolean> registerUser(@RequestBody  RegisterUser registerUser) {
        return iRoleLoginService.registerUser(registerUser);
    }
}

