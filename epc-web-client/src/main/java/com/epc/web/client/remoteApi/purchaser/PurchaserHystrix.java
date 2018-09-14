package com.epc.web.client.remoteApi.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;

public class PurchaserHystrix implements FacadePurchaserService {
    @Override
    public Result<Boolean> createPurchaseBasicInfo(HandlePurchaser handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createExpertByPurchaser(HandleExpert handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createAgencyByPurchaser(HandleAgnecy handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserDetail(HandlePurchaser handlePurchaser) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy) {
        return Result.hystrixError();
    }
}
