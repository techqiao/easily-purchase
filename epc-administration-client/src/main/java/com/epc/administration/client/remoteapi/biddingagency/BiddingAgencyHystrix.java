package com.epc.administration.client.remoteapi.biddingagency;

import com.epc.administration.facade.biddingagency.BiddingAgencyService;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;

/**
 * <p>Description : easily-purchase
 * @date 2018-09-14 10:15:32
 * @author lzx
 */
public class BiddingAgencyHystrix  implements BiddingAgencyService {

    @Override
    public Result<Boolean> insertBiddingAgencyBasicInfo(UserBasicInfo userBasicInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertBiddingAgencyDetailInfo(RoleDetailInfo roleDetailInfo) {
        return null;
    }

    @Override
    public Result<Boolean> deleteBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result queryBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }

    @Override
    public Result selectBiddingAgencyDetailInfo(QueryDetailIfo queryDetailIfo) {
        return Result.hystrixError();
    }
}
