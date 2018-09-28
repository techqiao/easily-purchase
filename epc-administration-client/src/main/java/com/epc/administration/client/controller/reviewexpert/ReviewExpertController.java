package com.epc.administration.client.controller.reviewexpert;

import com.epc.administration.client.controller.operator.handle.ClientUserBasicInfo;
import com.epc.administration.client.controller.reviewexpert.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.reviewexpert.handle.ClientRoleDetailInfo;
import com.epc.administration.client.remoteapi.reviewexpert.ReviewexpertClient;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.common.QueryRequest;
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

/**
 * @date 2018-9-13 09:44:58
 * @author luozhixin
 * 评审专家服务
 */
@Api(value = "评审专家服务",tags = {"评审专家服务"})
@RestController
@RequestMapping(value = "/reviewexpert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
class ReviewExpertController {

    @Autowired
    private ReviewexpertClient reviewExpertClient;

    @ApiOperation(value = "添加评审专家",notes = "添加评审专家")
    @PostMapping(value = "createReviewExpert", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createReviewExpert(@RequestBody ClientUserBasicInfo clientUserBasicInfo){
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,userBasicInfo);
        return reviewExpertClient.insertReviewExpertBasicInfo(userBasicInfo);


    }
    @ApiOperation(value = "评审专家完善资料",notes = "评审专家完善资料")
    @PostMapping(value = "registryReviewExpertDetail")
    public Result<Boolean> insertReviewExpertDetailInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo ) {
        ReviewExpertHandle reviewExpertHandle = new ReviewExpertHandle();
        BeanUtils.copyProperties(clientRoleDetailInfo,reviewExpertHandle);
        return reviewExpertClient.insertReviewExpertDetailInfo(reviewExpertHandle);
    }

    @ApiOperation(value = "评审专家删除资料",notes = "评审专家删除资料")
    @PostMapping(value = "deleteReviewExpertDetailInfo")
    public Result deleteReviewExpertDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return reviewExpertClient.deleteReviewExpertDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "评审专家查询资料",notes = "评审专家查询资料")
    @PostMapping(value = "queryReviewExpertDetailInfo")
    public Result queryReviewExpertDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return reviewExpertClient.queryReviewExpertDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "评审专家模糊搜索查询资料",notes = "评审专家模糊搜索查询资料")
    @PostMapping(value = "selectReviewExpertDetailInfo")
    public Result selectReviewExpertDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return reviewExpertClient.selectReviewExpertDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "查询所有评审专家分页展示",notes = "查询所有评审专家分页展示")
    @PostMapping(value ="selectAllExpertByPage" )
    public Result selectAllExpertByPage(@RequestBody QueryRequest queryRequest){
        return  reviewExpertClient.selectAllExpertByPage(queryRequest);
    }
}
