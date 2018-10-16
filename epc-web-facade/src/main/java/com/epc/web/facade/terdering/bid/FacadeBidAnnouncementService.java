package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.handle.HandleLetterTenderMemo;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderSubVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderVO;
import org.springframework.web.bind.annotation.*;

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
     * @return
     */
    @PostMapping(value = "queryBidAnnouncement", consumes = "application/json; charset=UTF-8")
    Result<List<BidAnnouncementVO>> queryBidAnnouncement(@RequestParam("bidId") Long bidId);


    /**
     * 获取公告一览表路径
     *
     * @param bidId
     * @return
     */
    @GetMapping(value = "bidAnnouncementDetail", consumes = "application/json; charset=UTF-8")
    Result<String> bidAnnouncementDetail(@RequestParam("bidId") Long bidId);


    /**
     * 获取唱标列表
     * @param procurementProjectId
     * @return
     */
    @GetMapping(value = "getLetterTenderList", consumes = "application/json; charset=UTF-8")
    Result<List<LetterTenderSubVO>> getLetterTenderList(@RequestParam(value = "procurementProjectId") Long procurementProjectId);

    /**
     * 唱标确认
     * @param handleLetterTenderMemo
     * @return
     */
    @PostMapping(value = "insertLetterTenderMemo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertLetterTenderMemo(@RequestBody List<HandleLetterTenderMemo> handleLetterTenderMemo);
}
