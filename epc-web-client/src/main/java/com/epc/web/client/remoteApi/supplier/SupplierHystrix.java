package com.epc.web.client.remoteApi.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.query.HandleSupplierNameAndCellphone;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;

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
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByCellphone handleFindSupplierByCellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierBasicInfoVO> findByName(HandleSupplierNameAndCellphone HandleSupplierNameAndCellphone) {
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
