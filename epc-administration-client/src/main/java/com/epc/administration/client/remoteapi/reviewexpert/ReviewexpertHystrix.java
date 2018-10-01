package com.epc.administration.client.remoteapi.reviewexpert;

import com.epc.administration.facade.reviewexpert.ReviewExpertService;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.ExpertForbiddenHandle;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-26 17:10
 * <p>@Author : luozhixin
 * <p>ReviewexpertHystrix
 */
public class ReviewexpertHystrix implements ReviewExpertService {

    @Override
    public Result<Boolean> insertReviewExpertBasicInfo(UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertReviewExpertDetailInfo(ReviewExpertHandle reviewExpertHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteReviewExpertDetailInfo(Long whereId) {
        return Result.hystrixError();
    }

    @Override
    public Result queryReviewExpertDetailInfo( Long whereId) {
        return Result.hystrixError();
    }


    @Override
    public Result selectAllExpertByPage(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> examineExpert(ExamineExpertHandle examineExpertHandle) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forbiddenExpertUser(ExpertForbiddenHandle expertForbiddenHandle) {
        return Result.hystrixError();
    }
}
