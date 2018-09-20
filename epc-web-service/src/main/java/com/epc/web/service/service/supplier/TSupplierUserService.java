package com.epc.web.service.service.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import com.epc.web.facade.supplier.handle.HandleSupplierForgetPassword;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface TSupplierUserService {



    /**
     * 注册供应商
     * @param handleSupplierDetail
     * @return
     */
    Result<Boolean> registerSupplier( HandleSupplierDetail handleSupplierDetail);

    /**
     *  登陆
     * @param cellphone
     * @param password
     * @return
     */
    Result<SupplierBasicInfoVO> login( String cellphone, String password);

    /**
     * 查询用户信息，依据电话或者密码来查找这个人的详细信息
     * @param name
     * @param cellphone
     * @return
     */
    Result<SupplierDetailInfoVO> findByName(String name, String cellphone);

    /**
     * 忘记密码
     * @param handleSupplierForgetPassword
     */
    Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword);



}
