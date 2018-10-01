package com.epc.administration.client.controller.biddingagency;


import com.epc.administration.client.controller.biddingagency.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.biddingagency.handle.ClientAgencyForbiddenHandle;
import com.epc.administration.client.controller.biddingagency.handle.ClientBiddingAgencyDetailInfo;
import com.epc.administration.client.controller.biddingagency.handle.ClientExamineAgencyHandle;
import com.epc.administration.client.controller.biddingagency.handle.ClientUserBasicInfo;
import com.epc.administration.client.remoteapi.biddingagency.BiddingAgencyClient;
import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.AgencyForbiddenHandle;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.administration.facade.biddingagency.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 招标代理机构接口
 * @author luozhixin
 * @date 2018-9-19 19:26:15
 */
@Api(value = "招标代理机构服务 @罗志鑫",tags = {"招标代理机构服务"})
@RestController
@RequestMapping(value = "/biddingagency", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingAgencyController {

    @Autowired
    private BiddingAgencyClient biddingAgencyClient;

    @ApiOperation(value = "添加招标代理机构",notes = "添加招标代理机构")
    @PostMapping(value = "createBiddingAgencyUser", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createBiddingAgencyUser(@RequestBody ClientUserBasicInfo clientUserBasicInfo){
        UserBasicInfo pojo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,pojo);
        return biddingAgencyClient.insertBiddingAgencyBasicInfo(pojo);
    }

    @ApiOperation(value = "招标代理机构完善资料",notes = "招标代理机构完善资料")
    @PostMapping(value = "registryBiddingAgencyDetail",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody ClientBiddingAgencyDetailInfo clientBiddingAgencyDetailInfo) {
        BiddingHandle biddingHandle = new BiddingHandle();
        BeanUtils.copyProperties(clientBiddingAgencyDetailInfo,biddingHandle);
        return biddingAgencyClient.insertBiddingAgencyDetailInfo(biddingHandle);
    }


    @ApiOperation(value = "招标代理机构删除资料",notes = "招标代理机构删除资料")
    @GetMapping(value = "deleteBiddingAgencyDetailInfo")
    public Result deleteBiddingAgencyDetailInfo(@RequestParam("whereId") Long whereId) {
        return biddingAgencyClient.deleteBiddingAgencyDetailInfo(whereId);
    }

    @ApiOperation(value = "招标代理机构查询资料",notes = "招标代理机构查询资料")
    @GetMapping(value = "queryBiddingAgencyDetailInfo")
    public Result queryBiddingAgencyDetailInfo(@RequestParam("whereId") Long whereId) {
        return biddingAgencyClient.queryBiddingAgencyDetailInfo(whereId);
    }


    @ApiOperation(value = "分页查询所有招标代理机构" ,notes = "分页查询所有招标代理机构")
    @PostMapping(value = "selectAllAgencyByPage",consumes = "application/json;charset=UTF-8")
    public Result selectAllAgencyByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo){
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return biddingAgencyClient.selectAllAgencyByPage(queryDetailIfo);
    }

    @ApiOperation(value = "审核招标代理机构",notes = "审核招标代理机构")
    @PostMapping(value = "examineAgency",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> examineAgency(@RequestBody ClientExamineAgencyHandle clientExamineAgencyHandle){
        ExamineAgencyHandle examineAgencyHandle= new ExamineAgencyHandle();
        BeanUtils.copyProperties(clientExamineAgencyHandle,examineAgencyHandle);
        return biddingAgencyClient.examineAgency(examineAgencyHandle);
    }

    @ApiOperation(value = "禁用解禁招标代理机构",notes = "禁用解禁招标代理机构")
    @PostMapping("forbiddenAgencyUser")
    public Result<Boolean> forbiddenAgencyUser(@RequestBody ClientAgencyForbiddenHandle clientAgencyForbiddenHandle){
        AgencyForbiddenHandle agencyForbiddenHandle = new AgencyForbiddenHandle();
        BeanUtils.copyProperties(clientAgencyForbiddenHandle,agencyForbiddenHandle);
        return biddingAgencyClient.forbiddenAgencyUser(agencyForbiddenHandle);
    }
}
