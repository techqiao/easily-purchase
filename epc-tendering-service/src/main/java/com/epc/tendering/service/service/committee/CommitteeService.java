package com.epc.tendering.service.service.committee;

import com.epc.common.Result;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;

public interface CommitteeService {

    /**
     * 组建委员会
     * @param dto
     * @return
     */
        Result<Boolean> createBAssessmentCommittee(QueryExtractExpertList dto);

    }