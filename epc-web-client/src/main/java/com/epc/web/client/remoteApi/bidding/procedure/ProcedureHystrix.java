package com.epc.web.client.remoteApi.bidding.procedure;

import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeProcedureService;
import com.epc.web.facade.bidding.query.schedule.HandleProjectSchedule;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;

public class ProcedureHystrix  implements FacadeProcedureService {
    @Override
    public Result<String> queryProjectSchedule(QueryProjectSchedule dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertProjectSchedule(HandleProjectSchedule dto) {
        return Result.hystrixError();
    }
}
