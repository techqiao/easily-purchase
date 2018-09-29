package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description: 唱标业务
 * @Author: linzhixiang
 * @Date:
 */ 
public interface BidAnnouncementService {

    /**
     * 新增一条唱标记录
     * @return
     */
     Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement);


    /**
     * 公开供应商投标附录
     * @param queryBidAnnouncement
     * @return
     */
     Result<List<BidAnnouncementVO>> queryBidAnnouncement( QueryBidAnnouncement queryBidAnnouncement) ;

    /**
     * 查询唱标记录路径
     * @return
     */
     Result<String> BidAnnouncementDetail(Long bidId);

    }