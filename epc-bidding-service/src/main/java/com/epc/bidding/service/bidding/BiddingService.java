package com.epc.bidding.service.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleNotice;
import com.epc.web.facade.bidding.handle.HandlePretriaFile;
import com.epc.web.facade.bidding.handle.HandleQuestion;
import com.epc.web.facade.bidding.query.answerQuestion.QueryAnswerQuestionDTO;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.query.schedule.HandleProjectSchedule;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.PretrialMessageVO;
import com.epc.web.facade.bidding.vo.QueryAnswerQuestionListVO;

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
     * @return
     */
    Result<NoticeDetailVO> findByNoticeId(QueryNoticeDetail queryNoticeDetail);

    /**
     * 查询供应商是否支付下载招标文件金额
     * @return
     */
    Boolean IsPayForProjectFile(QueryProgramPayDTO dto);

    /**
     * 投标上传
     * @param handleNotice
     * @return
     */
     Result<Boolean> insertNotice(HandleNotice handleNotice);

    /**
     * 预审信息 修改/删除
     * @param handlePretriaFile
     * @return
     */
    Result<Boolean> updatePretrialFile(HandlePretriaFile handlePretriaFile) ;

    /**
     * 获取预审信息 详情
     * @param handlePretriaFile
     * @return
     */
    Result<PretrialMessageVO> getTPretrialMessage(HandlePretriaFile handlePretriaFile);

    }
