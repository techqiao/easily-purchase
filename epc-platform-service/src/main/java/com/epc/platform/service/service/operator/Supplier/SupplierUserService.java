package com.epc.platform.service.service.operator.Supplier;

import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;

public interface SupplierUserService {
    /**
     * 运营商新增员工
     * @param userBasicInfo
     * @return
     */
    Result createSupplierUser(UserBasicInfo userBasicInfo);
}
