package com.epc.web.service.service;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.loginuser.dto.Loginer;
import com.epc.web.facade.loginuser.dto.ModifyUser;
import com.epc.web.facade.loginuser.dto.RegisterUser;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author winlin
 */
public interface IRoleLoginService {
    //运营商
    int OPERRATOR = 1;
    //代理机构
    int AGENCY = 2;
    //供应商
    int SUPPLIER = 3;
    //采购人
    int PURCHASER = 4;
    //评标专家
    int EXPERT = 5;

    /**
     * @param: 页面登录信息传入后端
     * @return: 返回详细信息
     * @date:2018/9/18
     */
    public Result<LoginUser> operatorLogin(Loginer loginer);

    public Result<LoginUser> purchaserLogin(Loginer loginer);

    public Result<LoginUser> agencyLogin(Loginer loginer);

    public Result<LoginUser> supplierLogin(Loginer loginer);

    public Result<LoginUser> expertLogin(Loginer loginer);

    /**
     * @author :winlin
     * @Description :角色注册
     * @date:2018/10/11
     */
    public Result<Boolean> registerOperator(RegisterUser registerUser);

    public Result<Boolean> registerPurchaser(RegisterUser registerUser);

    public Result<Boolean> registerAgency(RegisterUser registerUser);

    public Result<Boolean> registerSupplier(RegisterUser registerUser);

    public Result<Boolean> registerExpert(RegisterUser registerUser);

    /**
     * @author :winlin
     * @Description :修改密码
     * @date:2018/10/11
     */
    public Result<Boolean> modifyPasswordOperator(ModifyUser user);

    public Result<Boolean> modifyPasswordSupplier(ModifyUser user);

    public Result<Boolean> modifyPasswordAgency(ModifyUser user);

    public Result<Boolean> modifyPasswordExpert(ModifyUser user);

    public Result<Boolean> modifyPasswordPurchaser(ModifyUser user);

    public Result retrieveVerifyCode(String cellphone);

    /**
     * @author :winlin
     * @Description :统一注册接口
     * @param:
     * @return:
     * @date:2018/10/1
     */
    Result<Boolean> registerUser(RegisterUser registerUser);

    /**
     * @author :winlin
     * @Description :修改密码
     * @param:
     * @return:
     * @date:2018/10/3
     */
    Result<Boolean> modifyPassword(ModifyUser modifyUser);
}
