package com.epc.web.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.service.service.IRoleLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

        String  token = UUID.randomUUID().toString().replaceAll("-", "");
        Result result= iRoleLoginService.login(user);
        String epcToken = "EPC_PRIVATE_"+token;
        System.out.println("epcToken====="+epcToken);

//        Result result = iRoleLoginService.login(user ,token);

        if(result.isSuccess()) {
            RedisShardedPoolUtil.setEx(epcToken, JSONObject.toJSONString(result.getData()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
       if(result.getData()!=null){
           LoginUser loginUser = (LoginUser) result.getData();
           return Result.success("登陆成功",loginUser);
       }
        return Result.error(ErrorMessagesEnum.LOGIN_USER_LOGIN_ERROR);
    }
}
/**
 *  String  token = UUID.randomUUID().toString().replaceAll("-", "");
 *        String epcToken = "EPC_PRIVATE_"+token;
 *         Result<SysAdminUser> result = sysAdminUserService.login(loginHandle ,token);
 *         if(result.isSuccess()) {
 *             RedisShardedPoolUtil.setEx(epcToken, JSONObject.toJSONString(result.getData()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
 *         }
 *         return result;
 */
