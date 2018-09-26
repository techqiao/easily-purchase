package com.epc.web.client.controller.terdering.committee;


import com.epc.common.Result;
import com.epc.web.client.controller.terdering.committee.query.ClientExtractExpertList;
import com.epc.web.client.remoteApi.terdering.committee.CommitteeClient;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class CommitteeController {

    @Autowired
    private CommitteeClient committeeClient;

    @ApiOperation(value = "组建委员会")
    @PostMapping(value="/createBAssessmentCommittee")
    Result<Boolean> createBAssessmentCommittee(@RequestBody  ClientExtractExpertList dto){
        QueryExtractExpertList queryExtractExpertList=new QueryExtractExpertList();
        BeanUtils.copyProperties(dto,queryExtractExpertList);
       return committeeClient.createBAssessmentCommittee(queryExtractExpertList);
    }

}
