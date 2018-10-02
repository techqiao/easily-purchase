
package com.epc.administration.facade.reviewexpert;

import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.ExpertForbiddenHandle;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.vo.ReviewExpertVO;
import com.epc.common.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
     * 评审专家完善资料
     * @param reviewExpertHandle
     * @return
     */
    @PostMapping(value = "updateReviewExpertDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateReviewExpertDetailInfo(@RequestBody ReviewExpertHandle reviewExpertHandle);
    /**
     * 删除评审专家资料
     * @param whereId
     * @return
     */
    @GetMapping(value = "deleteReviewExpertDetailInfo" )
    Result<Boolean> deleteReviewExpertDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询评审专家详情
     * @param whereId
     * @return
     */
    @GetMapping(value = "queryReviewExpertDetailInfo" )
    Result queryReviewExpertDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 查询所有评审专家 分页展示
     * @param queryDetailIfo
     * @return
     */
    @PostMapping(value = "selectAllExpertByPage" , consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> selectAllExpertByPage(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 审核评审专家
     * @param examineExpertHandle
     * @return
     */
    @PostMapping(value = "examineExpert" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> examineExpert(@RequestBody ExamineExpertHandle examineExpertHandle);

    /**
     * 启用锁定评审专家
     * @param expertForbiddenHandle
     * @return
     */
    @PostMapping(value = "forbiddenExpertUser",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forbiddenExpertUser(@RequestBody ExpertForbiddenHandle expertForbiddenHandle);
}
