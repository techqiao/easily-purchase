package com.epc.web.client.remoteApi.bidding.notice;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeNoticeService;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;

import java.util.List;

public abstract class NoticeHystrix implements FacadeNoticeService {

    public Result<List<NoticeDetailVO>> getQuestionListById(String supplierId) {
        return Result.hystrixError();
    }
}
