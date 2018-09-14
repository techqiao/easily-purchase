package com.epc.platform.service.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.service.admin.SysAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Description : 用户登录
 * <p>Date : 2018-09-12 20:06
 * <p>@Author : wjq
 */
@RestController
public class LoginController extends BaseController{

    @Autowired
    private SysAdminUserService sysAdminUserService;

    //用户登录
    public Result<SysAdminUser> login(String phone, String password, HttpSession session, HttpServletResponse httpServletResponse){
        Result<SysAdminUser> result  = sysAdminUserService.login(phone, password);
        if(result.isSuccess()) {
            CookieUtil.writeLoginToken(httpServletResponse,session.getId());
            RedisShardedPoolUtil.setEx(session.getId(), JSONObject.toJSONString(result.getData()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        return result;
    }


    //用户登出
    public Result<Boolean> loginOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        CookieUtil.delLoginToken(httpServletRequest,httpServletResponse);
        RedisShardedPoolUtil.del(loginToken);
        return Result.success();
    }

}
