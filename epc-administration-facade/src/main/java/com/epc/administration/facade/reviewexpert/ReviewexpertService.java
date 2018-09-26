package com.epc.administration.facade.reviewexpert;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * <p>Description : easilys
 * <p>Date : 2018-09-26 16:00
 * <p>@Author : luozhixin
 * <p>ReviewExpertService
 */
public interface ReviewExpertService {
    /**
     * 评审专家注册
     * @param userBasicInfo 基本信息
     * @return
     */
    @PostMapping(value = "insertReviewExpertBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertReviewExpertBasicInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 评审专家完善资料
     * @param reviewExpertHandle
     * @return
     */
    @PostMapping(value = "insertReviewExpertDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertReviewExpertDetailInfo(@RequestBody ReviewExpertHandle reviewExpertHandle);

    /**
     * 删除评审专家资料
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "deleteReviewExpertDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据id查询评审专家详情
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "queryReviewExpertDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result queryReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 根据模糊name查询评审专家详情
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectReviewExpertDetailInfo" , consumes = "application/json; charset=UTF-8")
    Result selectReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo);


    /**
     * 查询所有评审专家 分页展示
     * @param queryRequest
     * @return
     */
    @PostMapping(value = "selectAllExpertByPage" , consumes = "application/json; charset=UTF-8")
    Result selectAllExpertByPage(@RequestBody QueryRequest queryRequest);
}

