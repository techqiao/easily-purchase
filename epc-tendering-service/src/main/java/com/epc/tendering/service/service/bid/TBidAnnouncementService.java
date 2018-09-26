package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;

import java.util.List;

public interface TBidAnnouncementService {

     Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement);


     Result<List<BidAnnouncementVO>> queryBidAnnouncement(QueryBidAnnouncement queryBidAnnouncement) ;



    }
