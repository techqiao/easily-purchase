package com.epc.web.client.remoteApi.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.FacadeExpertSignService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.query.QueryExpertDTO;
import com.epc.web.facade.terdering.bid.vo.ExpertSignVO;
import com.epc.web.facade.terdering.bid.vo.SignVO;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:53
 * <p>@Author : wjq
 */
public class ExpertSignHystrix implements FacadeExpertSignService {
    @Override
    public Result<Boolean> insertExpertSign(HandleExpertSign handleExpertSign) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> handleExpert(HandleExpertSign handleExpertSign) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<SignVO>> getExpertList(QueryExpertDTO queryExpertDTO) {
        return Result.hystrixError();
    }


}
