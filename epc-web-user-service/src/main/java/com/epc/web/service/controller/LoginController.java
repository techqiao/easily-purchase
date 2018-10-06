package com.epc.web.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.util.MD5Util;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.Loginer;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import com.epc.web.service.service.IRoleLoginService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author :winlin
 * @Description :
 * @param:
 * @return:
 * @date:2018/9/18
 */
@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginController implements FacadeLoginUserService {

    @Autowired
    IRoleLoginService iRoleLoginService;

    @Override
    public Result login(@RequestBody Loginer user) {
        //用户类型
        Integer type = user.getType();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                return iRoleLoginService.operatorLogin(user);
            case IRoleLoginService.AGENCY:
                return iRoleLoginService.agencyLogin(user);
            case IRoleLoginService.SUPPLIER:
                return iRoleLoginService.supplierLogin(user);
            case IRoleLoginService.PURCHASER:
                return iRoleLoginService.purchaserLogin(user);
            case IRoleLoginService.EXPERT:
                return iRoleLoginService.expertLogin(user);
            default:
                return Result.error("登录失败");
        }
    }

    @Override
    public Result<Boolean> registerUser(@RequestBody RegisterUser user) {
        //用户类型
        Integer type = user.getType();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                return iRoleLoginService.registerOperator(user);
            case IRoleLoginService.AGENCY:
               return iRoleLoginService.registerAgency(user);
            case IRoleLoginService.SUPPLIER:
                return  iRoleLoginService.registerSupplier(user);
            case IRoleLoginService.PURCHASER:
                return  iRoleLoginService.registerPurchaser(user);
            case IRoleLoginService.EXPERT:
               return iRoleLoginService.registerExpert(user);
            default:
                return Result.error("注册失败");
        }
    }

    @Override
    public Result<Boolean> modifyPassword(@RequestBody ModifyUser user) {
        Integer type = user.getType();
        switch (type) {
            case IRoleLoginService.OPERRATOR:
                return iRoleLoginService.modifyPasswordOperator(user);
            case IRoleLoginService.AGENCY:
                return iRoleLoginService.modifyPasswordAgency(user);
            case IRoleLoginService.SUPPLIER:
                return  iRoleLoginService.modifyPasswordSupplier(user);
            case IRoleLoginService.PURCHASER:
                return  iRoleLoginService.modifyPasswordPurchaser(user);
            case IRoleLoginService.EXPERT:
                return iRoleLoginService.modifyPasswordExpert(user);
            default:
                return Result.error("密码修改失败");
        }
    }
}

