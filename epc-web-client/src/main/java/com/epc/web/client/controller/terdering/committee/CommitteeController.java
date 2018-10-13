package com.epc.web.client.controller.terdering.committee;


import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.committee.handle.ClientCommittee;
import com.epc.web.client.controller.terdering.committee.query.ClientExtractExpertList;
import com.epc.web.client.remoteApi.terdering.committee.CommitteeClient;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
import com.epc.web.facade.terdering.committee.vo.CommittVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 组建委员会
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Api(value = "委员会",tags = "组建专家")
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class CommitteeController extends BaseController {

    @Autowired
    private CommitteeClient committeeClient;

    @ApiOperation(value = "创建委员会信息")
    @PostMapping(value="/createCommittee")
    Result<Long> createCommittee(@RequestBody ClientCommittee dto){
        HandleCommittee HandleCommittee=new HandleCommittee();
        BeanUtils.copyProperties(dto,HandleCommittee);
        HandleCommittee.setOperateId(getLoginUser().getUserId());
        return  committeeClient.createCommittee(HandleCommittee);
    }


    @ApiOperation(value = "根据委员会信息Id组建专家")
    @PostMapping(value="/createBAssessmentCommittee")
    Result<List<CommittVO>> createBAssessmentCommittee(@RequestBody  ClientExtractExpertList dto){
        QueryExtractExpertList queryExtractExpertList=new QueryExtractExpertList();
        BeanUtils.copyProperties(dto,queryExtractExpertList);
        queryExtractExpertList.setOperateId(getLoginUser().getUserId());
        return committeeClient.createBAssessmentCommittee(queryExtractExpertList);
    }
}