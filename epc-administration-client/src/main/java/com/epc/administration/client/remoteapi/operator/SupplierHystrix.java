package com.epc.administration.client.remoteapi.operator;

import com.epc.administration.facade.operator.SupplierUserService;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;

public class SupplierHystrix implements SupplierUserService {
    @Override
    public Result<Boolean> createSupplierUser(UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }
}
