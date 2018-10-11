package com.epc.web.client.remoteApi.loginuser;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.Loginer;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;

public class LoginUserHystrix implements FacadeLoginUserService {
    @Override
    public Result login(Loginer user) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> registerUser(RegisterUser registerUser) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> modifyPassword(ModifyUser modifyUser) {
         return Result.hystrixError();
    }

    @Override
    public Result retrieveVerifyCode(String cellphone) {
        return Result.hystrixError();
    }
}
