package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.BidAnnouncementService;
import com.epc.web.facade.terdering.bid.FacadeBidAnnouncementService;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderSubVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @Description: 唱标业务
 * @Author: linzhixiang
 * @Date: 2018/9/28
 */ 
@RestController
public class TBidAnnouncementController implements FacadeBidAnnouncementService {


    @Autowired
    BidAnnouncementService bidAnnouncementService;

    /**
     * 插入一条唱标记录
     * @param handleBidAnnouncement
     * @return
     */
    @Override
    public Result<Boolean> insertBidAnnouncement(@RequestBody  HandleBidAnnouncement handleBidAnnouncement){
       return bidAnnouncementService.insertBidAnnouncement(handleBidAnnouncement);
    }


    /**
     * 根据标段查询 供应商投标报告
     * @return
     */
    @Override
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(Long bidId) {
        return bidAnnouncementService.queryBidAnnouncement(bidId);
    }


    /**
     * 获取公告一览表路径
     * @param bidId
     * @return
     */
    @Override
    public Result<String> bidAnnouncementDetail(Long bidId){
        return bidAnnouncementService.BidAnnouncementDetail(bidId);
    }

    @Override
    public Result<List<LetterTenderSubVO>> getLetterTenderList(@RequestParam(value = "procurementProjectId") Long procurementProjectId) {
        return bidAnnouncementService.getLetterTenderList(procurementProjectId);
    }

}
