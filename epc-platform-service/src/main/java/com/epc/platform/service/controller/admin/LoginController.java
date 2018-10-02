package com.epc.platform.service.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.epc.administration.facade.admin.AdminLoginService;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.CookieUtil;
import com.epc.common.util.RedisShardedPoolUtil;
import com.epc.platform.service.domain.admin.SysAdminUser;
import com.epc.platform.service.service.admin.SysAdminUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * <p>Description : 用户登录
 * <p>Date : 2018-09-12 20:06
 * <p>@Author : wjq
 */
@Api(value = "用户登录", description = "用户登录")
@RestController
@SessionAttributes("session")
public class LoginController extends BaseController implements AdminLoginService {

    @Autowired
    private SysAdminUserService sysAdminUserService;

    /**用户登录
     * @param httpServletResponse
     * @param loginHandle
     * @return
     */
    @Override
    public Result<Map<String,Object>> login(
                                 HttpServletResponse httpServletResponse,
                                 @RequestBody LoginHandle loginHandle ){
        String  token = UUID.randomUUID().toString().replaceAll("-", "");
       String epcToken = "EPC_PRIVATE_"+token;
        Result<Map<String, Object>> result = sysAdminUserService.login(loginHandle, token);
        if(result.isSuccess()) {
            RedisShardedPoolUtil.setEx(epcToken, JSONObject.toJSONString(result.getData().get("user")), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        return result;
    }

    /**用户登出
     * @return
     */
    @Override
    @ResponseBody
    public Result loginOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        CookieUtil.delLoginToken(httpServletRequest,httpServletResponse);
        RedisShardedPoolUtil.del(loginToken);
        return Result.success();
    }

}
