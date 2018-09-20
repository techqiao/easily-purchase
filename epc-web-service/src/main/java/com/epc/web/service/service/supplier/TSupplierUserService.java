package com.epc.web.service.service.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.facade.supplier.handle.HandleSupplierForgetPassword;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TSupplierUserService {



    /**
     * 注册供应商
     * @param handleSupplierDetail
     * @return
     */
    @PostMapping(value = "registerSupplier",consumes = "application/json,charset=UTF-8")
    Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail);

    /**
     *  登陆
     * @param cellphone
     * @param password
     * @return
     */
    @PostMapping(value = "login",consumes = "application/json,charset=UTF-8")
    Result<SupplierBasicInfoVO> login(@RequestBody String cellphone, String password);

    /**
     * 查询用户信息，依据电话或者密码来查找这个人的详细信息
     * @param name
     * @param cellphone
     * @return
     */
    @PostMapping(value = "findByName",consumes = "application/json,charset=UTF-8")
    Result<SupplierDetailInfoVO> findByName(@RequestBody String name, String cellphone);

    /**
     * 忘记密码
     * @param handleSupplierForgetPassword
     */
    @PostMapping(value = "forgetPassword",consumes = "application/json,charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword);



}
