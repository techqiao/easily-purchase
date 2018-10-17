package com.epc.mobile.client.remoteApi.terdering.committee;

import com.epc.common.Result;
import com.epc.web.facade.terdering.committee.FacadeCommitteeService;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import com.epc.web.facade.terdering.committee.vo.CommittVO;

import java.util.List;

public class CommitteeHystrix implements FacadeCommitteeService {
    @Override
    public Result<Long> createCommittee(HandleCommittee dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<CommittVO>> createBAssessmentCommittee(QueryExtractExpertList dto) {
        return Result.hystrixError();
    }

}
