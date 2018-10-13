package com.epc.tendering.service.service.committee;

import com.epc.common.Result;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import com.epc.web.facade.terdering.committee.vo.CommittVO;

import java.util.List;

public interface CommitteeService {

    /**
     * 组建委员会
     * @param dto
     * @return
     */

     Result<Long> createCommittee(HandleCommittee dto);

    /**
     * 组建专家
     * @param dto
     * @return
     */
    Result<List<CommittVO>> createBAssessmentCommittee(QueryExtractExpertList dto);

    }
