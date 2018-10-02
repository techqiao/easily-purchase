package com.epc.administration.client.controller.reviewexpert;

import com.epc.administration.client.controller.common.BaseController;
import com.epc.administration.client.controller.reviewexpert.handle.ClientExpertDetailIfo;
import com.epc.administration.client.controller.reviewexpert.handle.ClientExpertForbiddenHandle;
import com.epc.administration.client.controller.reviewexpert.handle.ClientUserBasicInfo;
import com.epc.administration.client.controller.reviewexpert.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.reviewexpert.handle.ClientExamineExpertHandle;
import com.epc.administration.client.remoteapi.reviewexpert.ReviewexpertClient;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.administration.facade.reviewexpert.handle.ExamineExpertHandle;
import com.epc.administration.facade.reviewexpert.handle.ExpertForbiddenHandle;
import com.epc.administration.facade.reviewexpert.handle.UserBasicInfo;
import com.epc.administration.facade.reviewexpert.handle.ReviewExpertHandle;
import com.epc.administration.facade.reviewexpert.dto.QueryDetailIfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * @date 2018-9-13 09:44:58
 * @author luozhixin
 * 评审专家服务
 */
@Api(value = "评审专家服务 @罗志鑫",tags = {"评审专家服务"})
@RestController
@RequestMapping(value = "/reviewexpert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
class ReviewExpertController extends BaseController {

    @Autowired
    private ReviewexpertClient reviewExpertClient;

    @ApiOperation(value = "添加评审专家",notes = "添加评审专家")
    @PostMapping(value = "createReviewExpert", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createReviewExpert(@RequestBody ClientUserBasicInfo clientUserBasicInfo){
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,userBasicInfo);
        LoginHandle loginUser = getLoginUser();
        if(loginUser==null){
            return Result.error("请先登录");
        }
        userBasicInfo.setId(loginUser.getId());
        return reviewExpertClient.insertReviewExpertBasicInfo(userBasicInfo);
    }
    @ApiOperation(value = "评审专家完善资料",notes = "评审专家完善资料")
    @PostMapping(value = "registryReviewExpertDetail",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> insertReviewExpertDetailInfo(@RequestBody ClientExpertDetailIfo clientExpertDetailIfo) {
        ReviewExpertHandle reviewExpertHandle = new ReviewExpertHandle();
        BeanUtils.copyProperties(clientExpertDetailIfo,reviewExpertHandle);
        return reviewExpertClient.insertReviewExpertDetailInfo(reviewExpertHandle);
    }
    @ApiOperation(value = "修改评审专家资料",notes = "修改评审专家资料")
    @PostMapping(value = "updateReviewExpertDetailInfo",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> updateReviewExpertDetailInfo(@RequestBody ClientExpertDetailIfo clientExpertDetailIfo) {
        ReviewExpertHandle reviewExpertHandle = new ReviewExpertHandle();
        BeanUtils.copyProperties(clientExpertDetailIfo,reviewExpertHandle);
        return reviewExpertClient.updateReviewExpertDetailInfo(reviewExpertHandle);
    }
    @ApiOperation(value = "评审专家删除资料",notes = "评审专家删除资料")
    @GetMapping(value = "deleteReviewExpertDetailInfo")
    public Result deleteReviewExpertDetailInfo(@RequestParam("whereId") Long whereId) {
        return reviewExpertClient.deleteReviewExpertDetailInfo(whereId);
    }
    @ApiOperation(value = "评审专家查询资料",notes = "评审专家查询资料")
    @GetMapping(value = "queryReviewExpertDetailInfo")
    public Result queryReviewExpertDetailInfo(@RequestParam("whereId") Long whereId) {
        return reviewExpertClient.queryReviewExpertDetailInfo(whereId);
    }
    @ApiOperation(value = "查询所有评审专家分页展示",notes = "查询所有评审专家分页展示")
    @PostMapping(value ="selectAllExpertByPage" ,consumes = "application/json;charset=UTF-8")
    public Result<Map<String, Object>> selectAllExpertByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo){
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return  reviewExpertClient.selectAllExpertByPage(queryDetailIfo);
    }
    @ApiOperation(value = "审核评审专家", notes = "审核评审专家")
    @PostMapping(value = "examineExpert",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> examineExpert(@RequestBody ClientExamineExpertHandle clientExamineExpertHandle) {
        ExamineExpertHandle examineExpertHandle = new ExamineExpertHandle();
        BeanUtils.copyProperties(clientExamineExpertHandle, examineExpertHandle);
        return reviewExpertClient.examineExpert(examineExpertHandle);
    }

    @ApiOperation(value = "启用锁定评审专家",notes = "启用锁定评审专家")
    @PostMapping(value = "forbiddenExpertUser",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> forbiddenExpertUser(@RequestBody ClientExpertForbiddenHandle clientExpertForbiddenHandle){
        ExpertForbiddenHandle expertForbiddenHandle = new ExpertForbiddenHandle();
        BeanUtils.copyProperties(clientExpertForbiddenHandle,expertForbiddenHandle);
        return reviewExpertClient.forbiddenExpertUser(expertForbiddenHandle);
    }
}
