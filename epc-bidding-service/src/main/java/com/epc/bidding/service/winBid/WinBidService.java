package com.epc.bidding.service.winBid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;

import java.util.List;

public interface WinBidService {
    /**
     * 获取中标通知书列表
     * @param dto
     * @return
     */
    Result<List<WinBidLetterVO>> getWinBidLetter(QueryWinBidLetterDTO dto);
}
