package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.TBidAnnouncementService;
import com.epc.web.facade.terdering.bid.FacadeBidAnnouncementService;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TBidAnnouncementController implements FacadeBidAnnouncementService {


    @Autowired
    TBidAnnouncementService tBidAnnouncementService;

    /**
     * 插入一条唱标记录
     * @param handleBidAnnouncement
     * @return
     */
    @Override
    public Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement){
       return tBidAnnouncementService.insertBidAnnouncement(handleBidAnnouncement);
    }


    /**
     * 根据标段查询 供应商投标报告
     * @param queryBidAnnouncement
     * @return
     */
    @Override
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(QueryBidAnnouncement queryBidAnnouncement) {
        return tBidAnnouncementService.queryBidAnnouncement(queryBidAnnouncement);
    }

}
