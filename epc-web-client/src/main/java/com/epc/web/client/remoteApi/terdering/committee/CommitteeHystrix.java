package com.epc.web.client.remoteApi.terdering.committee;

import com.epc.common.Result;
import com.epc.web.facade.terdering.committee.FacadeCommitteeService;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;

public class CommitteeHystrix implements FacadeCommitteeService {
    @Override
    public Result<Long> createCommittee(HandleCommittee dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createBAssessmentCommittee(QueryExtractExpertList dto) {
        return Result.hystrixError();
    }
}
