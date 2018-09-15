package com.epc.administration.client.controller.reviewexpert;

import com.epc.administration.client.controller.reviewexpert.handle.ClientRoleDetailInfo;
import com.epc.administration.client.remoteapi.reviewexpert.ReviewexpertClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "评审专家",tags = {"评审专家"})
@RestController
@RequestMapping(value = "/reviewexpert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReviewexpertController {

    @Autowired
    private ReviewexpertClient reviewexpertClient;

    @ApiOperation(value = "添加评审专家",notes = "添加评审专家")
    @PostMapping(value = "createReviewexpert", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createReviewexpert(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo pojo = new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,pojo);
        return reviewexpertClient.insertReviewexpertDetailInfo(pojo);
    }
    @ApiOperation(value = "招标代理机构完善资料",notes = "招标代理机构完善资料")
    @PostMapping(value = "registryReviewExpertDetail")
    public Result<Boolean> insertReviewExpertDetailInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo ) {
        RoleDetailInfo pojo = new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,pojo);
        return reviewexpertClient.insertReviewexpertDetailInfo(pojo);
    }


    @ApiOperation(value = "招标代理机构删除资料",notes = "招标代理机构删除资料")
    @PostMapping(value = "deleteReviewExpertDetailInfo")
    public Result deleteReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return reviewexpertClient.deleteReviewexpertDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "招标代理机构查询资料",notes = "招标代理机构查询资料")
    @PostMapping(value = "queryReviewExpertDetailInfo")
    public Result queryReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return reviewexpertClient.queryReviewexpertDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "运营商模糊搜索查询资料",notes = "运营商模糊搜索查询资料")
    @PostMapping(value = "selectReviewExpertDetailInfo")
    public Result selectReviewExpertDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return reviewexpertClient.selectReviewexpertDetailInfo(queryDetailIfo);
    }
}
