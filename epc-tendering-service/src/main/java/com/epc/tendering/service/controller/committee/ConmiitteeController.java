package com.epc.tendering.service.controller.committee;

import com.epc.common.Result;
import com.epc.tendering.service.service.committee.CommitteeService;
import com.epc.web.facade.terdering.committee.FacadeCommitteeService;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CommiitteeController implements FacadeCommitteeService {

@Autowired
CommitteeService committeeService;

    @Override
    public Result<Boolean> createBAssessmentCommittee(@RequestBody QueryExtractExpertList dto){
        return  committeeService.createBAssessmentCommittee(dto);
    }


}
