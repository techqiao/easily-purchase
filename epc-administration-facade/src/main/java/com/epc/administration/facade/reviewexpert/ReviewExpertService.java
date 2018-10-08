
package com.epc.administration.facade.reviewexpert;

import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.ExpertForbiddenHandle;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.vo.ExpertDetailVO;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

/**
 * @author 01
 */
public interface ReviewExpertService {

    /**
     * 评审专家注册
     * @param userBasicInfo 基本信息
     * @return Boolean
     */
    @PostMapping(value = "insertReviewExpertBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertReviewExpertBasicInfo(@RequestBody UserBasicInfo userBasicInfo);

    /**
     * 评审专家完善资料
     * @param reviewExpertHandle
     * @return Boolean
     */
    @PostMapping(value = "insertReviewExpertDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertReviewExpertDetailInfo(@RequestBody ReviewExpertHandle reviewExpertHandle);

    /**
     * 评审专家完善资料
     * @param reviewExpertHandle
     * @return Boolean
     */
    @PostMapping(value = "updateReviewExpertDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateReviewExpertDetailInfo(@RequestBody ReviewExpertHandle reviewExpertHandle);
    /**
     * 删除评审专家资料
     * @param whereId
     * @return Boolean
     */
    @GetMapping(value = "deleteReviewExpertDetailInfo" )
    Result<Boolean> deleteReviewExpertDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 根据id查询评审专家详情
     * @param whereId
     * @return ExpertDetailVO
     */
    @GetMapping(value = "queryReviewExpertDetailInfo" )
    Result<ExpertDetailVO> queryReviewExpertDetailInfo(@RequestParam("whereId") Long whereId);

    /**
     * 查询所有评审专家 分页展示
     * @param queryDetailIfo
     * @return Result<Map<String, Object>>
     */
    @PostMapping(value = "selectAllExpertByPage" , consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> selectAllExpertByPage(@RequestBody QueryDetailIfo queryDetailIfo);

    /**
     * 审核评审专家
     * @param examineExpertHandle
     * @return Boolean
     */
    @PostMapping(value = "examineExpert" , consumes = "application/json; charset=UTF-8")
    Result<Boolean> examineExpert(@RequestBody ExamineExpertHandle examineExpertHandle);

    /**
     * 启用锁定评审专家
     * @param expertForbiddenHandle
     * @return Boolean
     */
    @PostMapping(value = "forbiddenExpertUser",consumes = "application/json;charset=UTF-8")
    Result<Boolean> forbiddenExpertUser(@RequestBody ExpertForbiddenHandle expertForbiddenHandle);
}
