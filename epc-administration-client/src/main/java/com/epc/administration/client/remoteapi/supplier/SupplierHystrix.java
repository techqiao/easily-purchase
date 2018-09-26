package com.epc.administration.client.remoteapi.supplier;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.SupplierUserService;
import com.epc.administration.facade.supplier.handle.SupplierHandle;
import com.epc.common.QueryRequest;
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
    public Result<Boolean> deleteSupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result querySupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectSupplierDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAllSupplierByPage(QueryRequest queryRequest) {
        return Result.hystrixError();
    }
}
