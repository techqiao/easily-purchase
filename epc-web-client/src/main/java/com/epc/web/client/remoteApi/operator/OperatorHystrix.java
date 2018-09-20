package com.epc.web.client.remoteApi.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.operator.handle.HandleOperatorDetail;
import com.epc.web.facade.operator.handle.HandleOperatorForgetPassword;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;

/**
 * <p>Description : easily-purchase 添加熔断器
 * <p>Date : 2018-09-10  18:10
 * <p>@author : lin
 */
public class OperatorHystrix implements FacadeOperatorService {


    @Override
    public Result<Boolean> registerOperator(HandleOperatorDetail HandleOperatorDetail) {
        return null;
    }

    @Override
    public Result<OperatorBasicInfoVO> findByName(String name, String cellphone) {
        return null;
    }

    @Override
    public Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword) {
        return null;
    }

    @Override
    public Result<Boolean> createOperatorUserInfo(HandleOperator handleOperator) {

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
