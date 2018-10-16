package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeBidAnnouncementService;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.handle.HandleLetterTenderMemo;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderSubVO;

import java.util.List;

public class BidAnnouncementHystrix implements FacadeBidAnnouncementService {
    @Override
    public Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(Long bidId) {
        return Result.hystrixError();
    }


    @Override
    public Result<String> bidAnnouncementDetail(Long bidId) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<LetterTenderSubVO>> getLetterTenderList(Long procurementProjectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertLetterTenderMemo(HandleLetterTenderMemo handleLetterTenderMemo) {
        return Result.hystrixError();
    }
}
