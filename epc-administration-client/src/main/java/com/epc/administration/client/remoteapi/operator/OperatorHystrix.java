package com.epc.administration.client.remoteapi.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.operator.handle.RoleDetailIfo;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:10
 * <p>@author : wjq
 */
public class OperatorHystrix implements FacadeOperatorService {
    @Override
    public Result<Boolean> insertOperatorBasicInfo(UserBasicInfo handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertOperatorDetailInfo(RoleDetailIfo roleDetailIfo) {
        return Result.hystrixError();
    }
}
