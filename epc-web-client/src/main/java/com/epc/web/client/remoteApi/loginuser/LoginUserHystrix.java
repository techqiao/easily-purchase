package com.epc.web.client.remoteApi.loginuser;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.FacadeLoginUserService;
import com.epc.web.facade.loginuser.dto.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserHystrix implements FacadeLoginUserService {
    @Override
    public Result login(LoginUser user) {
        return Result.hystrixError();
    }
}
