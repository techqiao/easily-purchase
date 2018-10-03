package com.epc.web.client.remoteApi.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;

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
    public Result<Boolean> addPasswordOperatorLogin(HandleOperator handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> addPasswordOperator(HandleOperator handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertCompleteOperatorInfo(RoleDetailInfo roleDetailInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee) {
        return Result.hystrixError();
    }

    @Override
    public Result<OperatorBasicInfoVO> findByName(HandleOperatorId handleOperatorId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> findOperatorRecordByCellphone(HandleOperatorCellphone handleOperatorCellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteOperatorEmployeeByCellphone(HandleOperatorCellphone handleOperatorCellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteOperatorEmployeeById(HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateOperatorEmployeeByisDeleted(HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createPurchaseByOperator(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createPurchaseByOperatorSimple(HandleOperatorCreateSupplier handleOperatorCreateSupplier) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> operatorCreateSupplierSimple(HandleOperatorCreateSupplier handleOperatorCreateSupplier) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> operatorCreateSupplier(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator) {
        return Result.hystrixError();
    }
}
