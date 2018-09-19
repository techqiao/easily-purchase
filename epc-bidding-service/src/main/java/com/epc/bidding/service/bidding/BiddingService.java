package com.epc.bidding.service.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleFileUpload;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.QueryAnswerQustionListVO;

import java.util.List;

public interface BiddingService {


    /**
     * 根据供应商Id查看公告列表
     * @param queryNoticeDTO
     * @return
     */
    Result<List<NoticeDetailVO>> findBySupplierId(QueryNoticeDTO queryNoticeDTO);


    /**
     *  查看公告详情 及 下载文件路径
     * @param queryNoticeDetail 公告详情
     * @param isPay 是否支付
     * @return
     */
    Result<NoticeDetailVO> findByNoticeId(QueryNoticeDetail queryNoticeDetail,Boolean isPay);

    /**
     * 查看公告答疑列表
     * @param queryAnswerQuestionDTO
     * @return
     */
    Result<List<QueryAnswerQustionListVO>> getAnswerQuestionfindByNoticeId(QueryAnswerQuestionDTO queryAnswerQuestionDTO);

    /**
     * 文件上传
     * @param handleFileUpload
     * @return
     */
    Result<Boolean> updatePretrialFile(HandleFileUpload handleFileUpload);

    /**
     * 查询供应商是否支付下载招标文件金额
     * @return
     */
    Result<Boolean> IsPayForProjectFile(QueryProgramPayDTO dto);

}
