package com.epc.web.facade.terdering.committee;

import com.epc.common.Result;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author linzhixiang
 * 组建委员会
 */
public interface FacadeCommitteeService {
    @PostMapping(value = "createBAssessmentCommittee", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createBAssessmentCommittee(@RequestBody  QueryExtractExpertList dto);

}
