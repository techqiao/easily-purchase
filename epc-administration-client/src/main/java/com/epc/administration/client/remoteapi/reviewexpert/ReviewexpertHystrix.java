package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.ReviewexpertService;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-10  18:10
 * <p>@author : wjq
 */
public class ReviewexpertHystrix implements ReviewexpertService {
    @Override
    public Result<Boolean> insertReviewexpertBasicInfo(UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertReviewexpertDetailInfo(RoleDetailInfo roleDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteReviewexpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result queryReviewexpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectReviewexpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }
}
