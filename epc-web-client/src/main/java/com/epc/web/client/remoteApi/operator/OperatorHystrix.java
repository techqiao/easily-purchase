package com.epc.web.client.remoteApi.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;

import java.util.List;

/**
 * <p>Description : easily-purchase 添加熔断器
 * <p>Date : 2018-09-10  18:10
 * <p>@author : lin
 */
public class OperatorHystrix implements FacadeOperatorService {


    @Override
    public Result<Boolean> registerOperator(HandleOperator handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<OperatorBasicInfoVO> findByName(HandleOperator handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createSupplierByOperator(HandleCreateSupplerByOperator handleCreateSupplerByOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createPurchaseByOperator(HandlePurchaser handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierDetail(HandleSupplierDetail handlePurchaser) {
        return Result.hystrixError();
    }




}
