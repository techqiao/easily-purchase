package com.epc.administration.client.controller.biddingagency;


import com.epc.administration.client.controller.biddingagency.dto.ClientQueryDetailIfo;
import com.epc.administration.client.controller.biddingagency.handle.ClientBaseDetailIfo;
import com.epc.administration.client.controller.biddingagency.handle.ClientUserBasicInfo;
import com.epc.administration.client.remoteapi.biddingagency.BiddingAgencyClient;
import com.epc.administration.facade.biddingagency.handle.BiddingHandle;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
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
 * 招标代理机构接口
 * @author luozhixin
 * @date 2018-9-19 19:26:15
 */
@Api(value = "招标代理机构服务",tags = {"招标代理机构服务"})
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
    @PostMapping(value = "registryBiddingAgencyDetail")
    public Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody ClientBaseDetailIfo clientBaseDetailIfo) {
        BiddingHandle biddingHandle = new BiddingHandle();
        BeanUtils.copyProperties(clientBaseDetailIfo,biddingHandle);
        return biddingAgencyClient.insertBiddingAgencyDetailInfo(biddingHandle);
    }


    @ApiOperation(value = "招标代理机构删除资料",notes = "招标代理机构删除资料")
    @PostMapping(value = "deleteBiddingAgencyDetailInfo")
    public Result deleteBiddingAgencyDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return biddingAgencyClient.deleteBiddingAgencyDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "招标代理机构查询资料",notes = "招标代理机构查询资料")
    @PostMapping(value = "queryBiddingAgencyDetailInfo")
    public Result queryBiddingAgencyDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return biddingAgencyClient.queryBiddingAgencyDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "招标代理机构模糊搜索查询资料",notes = "招标代理机构模糊搜索查询资料")
    @PostMapping(value = "selectBiddingAgencyDetailInfo")
    public Result selectBiddingAgencyDetailInfo(@RequestBody ClientQueryDetailIfo clientQueryDetailIfo) {
        QueryDetailIfo queryDetailIfo = new QueryDetailIfo();
        BeanUtils.copyProperties(clientQueryDetailIfo,queryDetailIfo);
        return biddingAgencyClient.selectBiddingAgencyDetailInfo(queryDetailIfo);
    }
    @ApiOperation(value = "分页查询所有招标代理机构" ,notes = "分页查询所有招标代理机构")
    @PostMapping(value = "selectAllAgencyByPage")
    public Result selectAllAgencyByPage(@RequestBody QueryRequest queryRequest){
        return biddingAgencyClient.selectAllAgencyByPage(queryRequest);
    }

   /* @ApiOperation(value = "审核招标代理机构",notes = "审核招标代理机构")
    @PostMapping(value = "examineAgency")
    public Result examineAgency(@RequestBody ExamineAgencyHandle examineAgencyHandle){
return Result.success();
    }*/
}
