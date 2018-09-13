package com.epc.platform.service.service.operator.impl;

import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import com.epc.platform.service.domain.operator.TOperatorBasicInfo;
import com.epc.platform.service.service.operator.Supplier.SupplierUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierUserServiceImpl implements SupplierUserService {

    @Autowired
    private TOperatorBasicInfo tOperatorBasicInfo;

    @Override
    public Result createSupplierUser(UserBasicInfo userBasicInfo) {

        return null;
    }
}
