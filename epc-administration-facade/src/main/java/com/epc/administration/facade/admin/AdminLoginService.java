package com.epc.administration.facade.admin;

import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.administration.facade.admin.vo.LoginVO;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-15 10:59
 * <p>@Author : luozhixin
 */

public interface AdminLoginService {
    /**用户登录
     * @param session
     * @param httpServletResponse
     * @param loginHandle
     * @return
     */
    @PostMapping(value = "login", consumes = "application/json; charset=UTF-8")
    @ResponseBody
     Result login( @RequestParam("session") HttpSession session,
                     @RequestParam("httpServletResponse")  HttpServletResponse httpServletResponse,
                           @RequestBody LoginHandle loginHandle);


    /**用户登出
     * @return
     */
    @PostMapping(value = "loginOut", consumes = "application/json; charset=UTF-8")
    @ResponseBody
    Result loginOut( @RequestParam("httpServletRequest") HttpServletRequest httpServletRequest,
                     @RequestParam("httpServletResponse") HttpServletResponse httpServletResponse);
}

