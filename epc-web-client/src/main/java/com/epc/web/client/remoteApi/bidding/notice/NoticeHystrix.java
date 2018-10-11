package com.epc.web.client.remoteApi.bidding.notice;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeNoticeService;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;

import java.util.List;
import java.util.Map;

public  class NoticeHystrix implements FacadeNoticeService {


    @Override
    public Result<Map<String, Object>> queryBIssueDocumentsList(QueryNoticeDTO queryNoticeDTO) {
        return  Result.hystrixError();
    }

    @Override
    public Result<List<AdvanceNoticeVO>> listAdvanceNotice(QueryAdvanceNoticeDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(Long id) {
        return Result.hystrixError();
    }

    @Override
    public NoticeDetailVO getNoticeDetail(QueryNoticeDetail queryNoticeDetail) {
        return null;
    }

}
