package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderSubVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description: 唱标业务
 * @Author: linzhixiang
 * @Date:
 */
public interface BidAnnouncementService {

    /**
     * 新增一条唱标记录
     *
     * @return
     */
    Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement);


    /**
     * 公开供应商投标附录
     *
     * @return
     */
    Result<List<BidAnnouncementVO>> queryBidAnnouncement(Long bidId);

    /**
     * 查询唱标记录路径
     *
     * @return
     */
    Result<String> BidAnnouncementDetail(Long bidId);

    /**
     * 获取唱标详情
     * @param procurementProjectId
     * @return
     */
    Result<List<LetterTenderSubVO>> getLetterTenderList(Long procurementProjectId);

}
