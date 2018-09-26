package com.epc.administration.client.remoteapi.admin;

import com.epc.administration.facade.admin.AdminLoginService;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.common.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 11:02
 * <p>@Author : luozhixinadmin
 */
public class AdminLoginHystrix implements AdminLoginService {
    @Override
    public Result login(HttpSession session, HttpServletResponse httpServletResponse, LoginHandle loginHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result loginOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return Result.hystrixError();
    }
}
