package com.epc.mobile.facade.loginer;

import com.epc.common.Result;
import com.epc.mobile.facade.loginer.dto.Loginer;
import com.epc.mobile.facade.loginer.dto.ModifyUser;
import com.epc.mobile.facade.loginer.dto.RegisterUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author :winlin
 * @Description :角色登录接口
 * @param:
 * @return:
 * @date:2018/9/18
 */
public interface FacadeMobileLoginUserService {
    @PostMapping(value = "login", consumes = "application/json; charset=UTF-8")
    Result login(@RequestBody Loginer user);
    /**
     * @author :winlin
     * @Description :统一注册接口
     * @date:2018/10/1
     */
    @PostMapping(value = "register", consumes = "application/json; charset=UTF-8")
    Result<Boolean> registerUser(@RequestBody RegisterUser registerUser);

    /**
     *@author :winlin
     *@Description :修改密码
     *@date:2018/10/3
     */
    @PostMapping(value = "modifyPassword", consumes = "application/json;charset=UTF-8")
    Result<Boolean> modifyPassword(@RequestBody ModifyUser modifyUser);
    /**
     *@author :winlin
     *@Description :验证码获取接口
     *@date:2018/10/16
     */
    @GetMapping(path = "retrieveVerifyCode/{cellphone}")
    Result retrieveVerifyCode(@PathVariable("cellphone") String cellphone);

}
