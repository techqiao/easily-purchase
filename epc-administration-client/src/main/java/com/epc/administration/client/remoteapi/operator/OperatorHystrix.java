package com.epc.administration.client.remoteapi.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.handle.HandleOperatorBasicInfo;
import com.epc.administration.facade.operator.handle.HandleOperatorDetailIfo;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:10
 * <p>@author : wjq
 */
public class OperatorHystrix implements FacadeOperatorService {
    @Override
    public Result<Boolean> insertOperatorBasicInfo(HandleOperatorBasicInfo handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertOperatorDetailInfo(HandleOperatorDetailIfo handleOperatorDetailIfo) {
        return Result.hystrixError();
    }
}
