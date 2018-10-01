package com.epc.web.client.remoteApi.bidding.winBid;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeWinBidService;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;

import java.util.List;

public class WinBidHystrix implements FacadeWinBidService {
    @Override
    public Result<List<WinBidLetterVO>> getWinBidLetter(QueryWinBidLetterDTO dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<TWinBidNominateVO> getTWinBidNominate(Long bidId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertTWinBidNominate(HandleWinBid handleWinBid) {
        return Result.hystrixError();
    }


}
