package com.epc.mobile.client.remoteApi;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.Loginer;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import org.springframework.stereotype.Component;

@Component
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

    @Override
    public Result<String> getTokenValue(String token) {
        return Result.hystrixError();
    }
}
