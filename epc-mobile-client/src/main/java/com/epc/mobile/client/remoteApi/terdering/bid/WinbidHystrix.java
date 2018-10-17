package com.epc.mobile.client.remoteApi.terdering.bid;


import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleWinBidding;
import com.epc.web.facade.bidding.vo.NominateVO;
import com.epc.web.facade.terdering.bid.FacadeWinBidRecordService;

import java.util.List;

public class WinbidHystrix implements FacadeWinBidRecordService {

    @Override
    public Result<List<NominateVO>> getTWinBidNominated(Long procurementProjectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateTWinBidNominated(List<HandleWinBidding> dtoList) {
        return Result.hystrixError();
    }
}
