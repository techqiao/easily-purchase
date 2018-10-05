package com.epc.tendering.service.controller.committee;

import com.epc.common.Result;
import com.epc.tendering.service.service.committee.CommitteeService;
import com.epc.web.facade.terdering.committee.FacadeCommitteeService;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommiitteeController implements FacadeCommitteeService {

@Autowired
CommitteeService committeeService;

    /**
     * 组建委员会
     * @param dto
     * @return
     */
    @Override
    public Result<Long> createCommittee(@RequestBody  HandleCommittee dto){
        return  committeeService.createCommittee(dto);
    }

    /**
     * 根据委员会Id组建专家
     * @param dto
     * @return
     */
    @Override
    public Result<Boolean> createBAssessmentCommittee(@RequestBody QueryExtractExpertList dto){
        return  committeeService.createBAssessmentCommittee(dto);
    }


}
