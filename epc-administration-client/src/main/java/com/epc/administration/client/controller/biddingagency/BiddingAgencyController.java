package com.epc.administration.client.controller.biddingagency;


import com.alibaba.fastjson.JSONObject;
import com.epc.administration.client.controller.biddingagency.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.biddingagency.handle.ClientAgencyForbiddenHandle;
import com.epc.administration.client.controller.biddingagency.handle.ClientBiddingAgencyDetailInfo;
import com.epc.administration.client.controller.biddingagency.handle.ClientExamineAgencyHandle;
import com.epc.administration.client.controller.biddingagency.handle.ClientUserBasicInfo;
import com.epc.administration.client.controller.common.BaseController;
import com.epc.administration.client.remoteapi.biddingagency.BiddingAgencyClient;
import com.epc.administration.facade.admin.handle.LoginHandle;
import com.epc.administration.facade.biddingagency.dto.QueryDetailIfo;
import com.epc.administration.facade.biddingagency.handle.AgencyForbiddenHandle;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.biddingagency.handle.ExamineAgencyHandle;
import com.epc.administration.facade.biddingagency.handle.UserBasicInfo;
import com.epc.common.RedisShardedPool;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.RedisShardedPoolUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 招标代理机构接口
 * @author luozhixin
 * @date 2018-9-19 19:26:15
 */
@Api(value = "招标代理机构服务 @罗志鑫",tags = {"招标代理机构服务"})
@RestController
@RequestMapping(value = "biddingagency", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingAgencyController extends BaseController {

    @Autowired
    private BiddingAgencyClient biddingAgencyClient;

    @ApiOperation(value = "添加招标代理机构",notes = "添加招标代理机构")
    @PostMapping(value = "/public/createBiddingAgencyUser", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createBiddingAgencyUser(@RequestBody ClientUserBasicInfo clientUserBasicInfo){
       /* LoginHandle loginHandle = new LoginHandle();
        loginHandle.setId(55L);
        loginHandle.setPhone("5555");
        loginHandle.setPassword("5555");
        loginHandle.setName("5555");
        RedisShardedPoolUtil.setEx("EPC_PRIVATE_5555",JSONObject.toJSONString(loginHandle),Const.RedisCacheExtime.REDIS_SESSION_EXTIME);*/
        UserBasicInfo pojo = new UserBasicInfo();
        BeanUtils.copyProperties(clientUserBasicInfo,pojo);
        LoginHandle loginUser = getLoginUser();
        if(loginUser==null){
            return Result.error("请先登录");
        }
        pojo.setId(loginUser.getId());
        return biddingAgencyClient.insertBiddingAgencyBasicInfo(pojo);
    }

    @ApiOperation(value = "招标代理机构完善资料",notes = "招标代理机构完善资料")
    @PostMapping(value = "registryBiddingAgencyDetail",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody ClientBiddingAgencyDetailInfo clientBiddingAgencyDetailInfo) {
        BiddingHandle biddingHandle = new BiddingHandle();
        BeanUtils.copyProperties(clientBiddingAgencyDetailInfo,biddingHandle);
        return biddingAgencyClient.insertBiddingAgencyDetailInfo(biddingHandle);
    }

    @ApiOperation(value = "修改招标代理机构资料",notes = "修改招标代理机构资料")
    @PostMapping(value = "updateBiddingAgencyDetailInfo",consumes = "application/json;charset=UTF-8")
    public Result<Boolean> updateBiddingAgencyDetailInfo(@RequestBody ClientBiddingAgencyDetailInfo clientBiddingAgencyDetailInfo) {
        BiddingHandle biddingHandle = new BiddingHandle();
        BeanUtils.copyProperties(clientBiddingAgencyDetailInfo,biddingHandle);
        return biddingAgencyClient.updateBiddingAgencyDetailInfo(biddingHandle);
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
    public Result<Map<String, Object>> selectAllAgencyByPage(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo){
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
