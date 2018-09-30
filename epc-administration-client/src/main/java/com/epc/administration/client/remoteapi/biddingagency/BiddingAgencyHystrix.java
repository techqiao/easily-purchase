package com.epc.administration.client.remoteapi.biddingagency;

import com.epc.administration.facade.biddingagency.BiddingAgencyService;
import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * @date 2018-09-14 10:15:32
 * @author lzx
 */
public class BiddingAgencyHystrix  implements BiddingAgencyService {

    @Override
    public Result<Boolean> insertBiddingAgencyBasicInfo(com.epc.administration.facade.biddingagency.handle.UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertBiddingAgencyDetailInfo(BiddingHandle biddingHandle) {
        return  Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteBiddingAgencyDetailInfo(Long whereId) {
        return  Result.hystrixError();
    }

    @Override
    public Result queryBiddingAgencyDetailInfo(Long whereId) {
        return Result.hystrixError();
    }

    @Override
    public Result selectAllAgencyByPage(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> examineAgency(ExamineAgencyHandle examineAgencyHandle) {
        return Result.hystrixError();
    }
}
