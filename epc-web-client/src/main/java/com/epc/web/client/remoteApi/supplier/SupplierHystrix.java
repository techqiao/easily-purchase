package com.epc.web.client.remoteApi.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;

import java.util.List;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13  15:10
 * <p>@author : donghuan
 */
public class SupplierHystrix implements FacadeTSupplierBasicInfoService {

    @Override
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierBasicInfoVO> login(String cellphone, String password) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierDetailInfoVO> findByName(String name, String cellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleSupplierFindAllByName handleSupplierFindAllByName) {
        return Result.hystrixError();
    }
    
}
