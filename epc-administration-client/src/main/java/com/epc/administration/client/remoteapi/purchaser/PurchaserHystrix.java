package com.epc.administration.client.remoteapi.purchaser;

import com.epc.administration.facade.purchaser.PurchaserUserService;
import com.epc.administration.facade.purchaser.handle.ExaminePurchaserHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserForbiddenHandle;
import com.epc.administration.facade.purchaser.handle.PurchaserHandle;
import com.epc.common.Result;

public class PurchaserHystrix implements PurchaserUserService {
    @Override
    public Result<Boolean> createPurchaserUserInfo(com.epc.administration.facade.purchaser.handle.UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertPurchaserDetailInfo(PurchaserHandle purchaserHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserDetailInfo(PurchaserHandle purchaserHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deletePurchaserDetailInfo(Long whereId) {
        return Result.hystrixError();
    }

    @Override
    public Result queryPurchaserDetailInfo(Long whereId) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAllPurchaserByPage(com.epc.administration.facade.purchaser.dto.QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result examinePurchaser(ExaminePurchaserHandle examinePurchaserHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forbiddenPurchaserUser(PurchaserForbiddenHandle purchaserForbiddenHandle) {
        return Result.hystrixError();
    }
}
