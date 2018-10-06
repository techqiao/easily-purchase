package com.epc.web.facade.loginuser;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :winlin
 * @Description :角色登录接口
 * @param:
 * @return:
 * @date:2018/9/18
 */
public interface FacadeLoginUserService {
    @PostMapping(value = "login", consumes = "application/json; charset=UTF-8")
    Result login(@RequestBody LoginUser user);

    /**
     * @author :winlin
     * @Description :统一注册接口
     * @param:
     * @return:
     * @date:2018/10/1
     */
    @PostMapping(value = "register", consumes = "application/json; charset=UTF-8")
    Result<Boolean> registerUser(@RequestBody RegisterUser registerUser);

    /**
     *@author :winlin
     *@Description :修改密码
     *@param:
     *@return:
     *@date:2018/10/3
     */
    @PostMapping(value = "modifyPassword", consumes = "application/json;charset=UTF-8")
    Result<Boolean> modifyPassword(@RequestBody ModifyUser modifyUser);
}
