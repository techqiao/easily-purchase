package com.epc.web.client.remoteApi.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;

import java.util.List;

/**
 * <p>Description : easily-purchase 添加熔断器
 * <p>Date : 2018-09-10  18:10
 * <p>@author : donghuan
 */
public class OperatorHystrix implements FacadeOperatorService {


    @Override
    public Result<Boolean> registerOperator(HandleOperator handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> addPasswordOperator(HandleOperator handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<OperatorBasicInfoVO> findByName(HandleOperatorId handleOperatorId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteOperatorEmployeeById(HandleOperatorId handleOperatorId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeByisDeleted(HandleOperatorId handleOperatorId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeStateById(HandleOperatorState handleOperatorState) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteOperatorEmployeeByCellphone(HandleOperatorCellphone handleOperatorCellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> findOperatorRecordByCellphone(HandleOperatorCellphone handleOperatorCellphone) {
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
    public Result<Boolean> createPurchaseByOperator(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator) {
        return Result.hystrixError();
    }


}
