package com.epc.platform.service.service.reviewexpert;

import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.ExpertForbiddenHandle;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.vo.ReviewExpertVO;
import com.epc.common.Result;
import com.epc.platform.service.domain.expert.TExpertDetailInfo;

import java.util.List;


/**
 * @author 01
 */
public interface ExpertService {
    /**
     * 预添加评审专家
     * @param userBasicInfo
     * @return
     */
    Result<Boolean> insertExpertBasicInfo(UserBasicInfo userBasicInfo);

    /**
     * 评审专家完善资料
     * @param reviewExpertHandle
     * @return
     */
    Result<Boolean> insertExpertDetailInfo(ReviewExpertHandle reviewExpertHandle);


    /**
     * 删除评审专家资料
     * @param whereId
     * @return
     */
    Result<Boolean> deleteExpertDetailInfo(Long whereId);

    /** 根据传入评审专家ID查询
     * 查询评审专家资料
     * @param whereId
     * @return
     */
    Result<TExpertDetailInfo> queryExpertDetailInfo( Long whereId);


    /**
     *
     * @param queryDetailIfo
     * @return
     */
    List<ReviewExpertVO> selectAllExpertByPage(QueryDetailIfo queryDetailIfo);

    /**
     * 审核评审专家
     * @param examineExpertHandle
     * @return
     */
    Result<Boolean> examineExpert(ExamineExpertHandle examineExpertHandle);

    /**
     * 启用锁定评审专家
     * @param expertForbiddenHandle
     * @return
     */
    Result<Boolean> forbiddenExpertUser(ExpertForbiddenHandle expertForbiddenHandle);
}
