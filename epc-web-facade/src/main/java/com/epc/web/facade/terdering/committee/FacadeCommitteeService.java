package com.epc.web.facade.terdering.committee;

import com.epc.common.Result;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author linzhixiang
 * 组建委员会
 */
public interface FacadeCommitteeService {

    /**
     * 创建委员会
     * @param dto
     * @return
     */
    @PostMapping(value = "createCommittee", consumes = "application/json; charset=UTF-8")
    Result<Long> createCommittee(@RequestBody HandleCommittee dto);

    /**
     * 根据委员会Id 组建人员
     * @param dto
     * @return
     */
     @PostMapping(value = "createBAssessmentCommittee", consumes = "application/json; charset=UTF-8")
      Result<Boolean> createBAssessmentCommittee(@RequestBody  QueryExtractExpertList dto);

}
