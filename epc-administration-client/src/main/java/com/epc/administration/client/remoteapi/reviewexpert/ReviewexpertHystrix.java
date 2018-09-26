package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewExpertService;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-26 16:48
 * <p>@Author : luozhixin
 * <p>ReviewExpertHystrix
 */
public class ReviewExpertHystrix  implements ReviewExpertService {
    @Override
    public Result<Boolean> insertReviewExpertBasicInfo(UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertReviewExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteReviewExpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result queryReviewExpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectReviewExpertDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAllExpertByPage(QueryRequest queryRequest) {
        return Result.hystrixError();
    }
}
