package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author linzhixiang
 * 唱标业务
 */
public interface FacadeBidAnnouncementService {


    /**
     * 插入一个唱标记录
     * @param handleBidAnnouncement
     * @return
     */
    @PostMapping(value = "insertBidAnnouncement")
    Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement);


    /**
     * 根据标段查询 供应商投标报告
     * @param queryBidAnnouncement
     * @return
     */
    @PostMapping(value = "queryBidAnnouncement")
    Result<List<BidAnnouncementVO>> queryBidAnnouncement(QueryBidAnnouncement queryBidAnnouncement);


}
