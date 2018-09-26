package com.epc.administration.client.remoteapi.operator;

import com.epc.administration.facade.operator.FacadeOperatorService;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
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
    public Result<Boolean> insertOperatorDetailInfo(RoleDetailInfo roleDetailInfo) {
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

    @Override
    public Result selectAllOperatorByPage(QueryRequest queryRequest) {
        return Result.hystrixError();
    }
}
