package com.epc.administration.client.remoteapi.supplier;

import com.epc.administration.facade.supplier.SupplierUserService;
import com.epc.administration.facade.supplier.dto.QueryDetailIfo;
import com.epc.administration.facade.supplier.handle.ExamineSupplierHandle;
import com.epc.administration.facade.supplier.handle.SupplierForbiddenHandle;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.administration.facade.supplier.handle.UserBasicInfo;
import com.epc.common.Result;

public class SupplierHystrix implements SupplierUserService {
    @Override
    public Result<Boolean> createSupplierUserInfo(UserBasicInfo userBasicInfo) {
       return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertSupplierDetailInfo(SupplierHandle supplierHandle) {
        return Result.hystrixError();
    }
    @Override
    public Result<Boolean> updateSupplierDetailInfo(SupplierHandle supplierHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteSupplierDetailInfo( Long whereId) {
        return Result.hystrixError();
    }

    @Override
    public Result querySupplierDetailInfo(Long whereId) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAllSupplierByPage(QueryDetailIfo queryRequest) {
        return Result.hystrixError();
    }

    @Override
    public Result examineSupplier(ExamineSupplierHandle examineSupplierHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forbiddenSupplierUser(SupplierForbiddenHandle supplierForbiddenHandle) {
        return Result.hystrixError();
    }
    @Override
    public Result supplierReviewWinningBid(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result supplierReviewRewardAndPunishment(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result supplierReviewRecordOfPerformance(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }
}
