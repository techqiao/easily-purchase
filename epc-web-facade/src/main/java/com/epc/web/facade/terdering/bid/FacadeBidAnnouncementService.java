package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author linzhixiang
 * 唱标业务
 */
public interface FacadeBidAnnouncementService {


    /**
     * 插入一个唱标记录
     *
     * @param handleBidAnnouncement
     * @return
     */
    @PostMapping(value = "insertBidAnnouncement", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertBidAnnouncement(@RequestBody HandleBidAnnouncement handleBidAnnouncement);


    /**
     * 根据标段查询 供应商投标报告
     *
     * @param queryBidAnnouncement
     * @return
     */
    @PostMapping(value = "queryBidAnnouncement", consumes = "application/json; charset=UTF-8")
    Result<List<BidAnnouncementVO>> queryBidAnnouncement(@RequestBody QueryBidAnnouncement queryBidAnnouncement);


    /**
     * 获取公告一览表路径
     *
     * @param bidId
     * @return
     */
    @GetMapping(value = "bidAnnouncementDetail", consumes = "application/json; charset=UTF-8")
    Result<String> bidAnnouncementDetail(@RequestParam("bidId") Long bidId);
}
