package com.epc.web.client.remoteApi.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.HandlerSupplierUser;


/**
 * <p>Description : easily-purchase 添加熔断器
 * <p>Date : 2018-09-13  15:10
 * <p>@author : donghuan
 */
public class SupplierHystrix implements FacadeTSupplierBasicInfoService {

    @Override
    public Result<Boolean> createSupplierUser(HandlerSupplierUser handlerSupplierUser) {
        return Result.hystrixError();
    }
    
}
