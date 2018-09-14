package com.epc.administration.client.remoteapi.supplier;

import com.epc.administration.facade.operator.Supplier.SupplierUserService;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;

public class SupplierHystrix implements SupplierUserService {
    @Override
    public Result<Boolean> createSupplierUserInfo(UserBasicInfo userBasicInfo) {
       return Result.hystrixError();
    }
}
