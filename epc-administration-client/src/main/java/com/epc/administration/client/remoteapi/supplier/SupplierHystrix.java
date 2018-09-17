package com.epc.administration.client.remoteapi.supplier;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.supplier.SupplierUserService;
import com.epc.common.Result;

public class SupplierHystrix implements SupplierUserService {
    @Override
    public Result<Boolean> createSupplierUserInfo(UserBasicInfo userBasicInfo) {
       return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertOperatorDetailInfo(RoleDetailInfo roleDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result queryOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectOperatorDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }
}
