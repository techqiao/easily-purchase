package com.epc.administration.client.controller.biddingagency;


import com.epc.administration.client.controller.operator.handle.ClientRoleDetailInfo;
import com.epc.administration.client.remoteapi.biddingagency.BiddingAgencyClient;
import com.epc.administration.facade.operator.dto.QueryDetailIfo;
import com.epc.administration.facade.operator.handle.RoleDetailInfo;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
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
 */
@Api(value = "招标代理机构",tags = {"招标代理机构"})
@RestController
@RequestMapping(value = "/biddingagency", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingAgencyController {

    @Autowired
    private BiddingAgencyClient biddingAgencyClient;

    @ApiOperation(value = "添加招标代理机构",notes = "添加招标代理机构")
    @PostMapping(value = "createBiddingAgencyUser", consumes = "application/json;charset=UTF-8")
    public Result<Boolean> createBiddingAgencyUser(@RequestBody UserBasicInfo userBasicInfo){
        return biddingAgencyClient.insertBiddingAgencyBasicInfo(userBasicInfo);
    }

    @ApiOperation(value = "招标代理机构完善资料",notes = "招标代理机构完善资料")
    @PostMapping(value = "registryBiddingAgencyDetail")
    public Result<Boolean> insertBiddingAgencyDetailInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo) {
        RoleDetailInfo pojo = new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,pojo);
        return biddingAgencyClient.insertBiddingAgencyDetailInfo(pojo);
    }


    @ApiOperation(value = "招标代理机构删除资料",notes = "招标代理机构删除资料")
    @PostMapping(value = "deleteBiddingAgencyDetailInfo")
    public Result deleteBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return biddingAgencyClient.deleteBiddingAgencyDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "招标代理机构查询资料",notes = "招标代理机构查询资料")
    @PostMapping(value = "queryBiddingAgencyDetailInfo")
    public Result queryBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return biddingAgencyClient.queryBiddingAgencyDetailInfo(queryDetailIfo);
    }

    @ApiOperation(value = "运营商模糊搜索查询资料",notes = "运营商模糊搜索查询资料")
    @PostMapping(value = "selectBiddingAgencyDetailInfo")
    public Result selectBiddingAgencyDetailInfo(@RequestBody QueryDetailIfo queryDetailIfo) {
        return biddingAgencyClient.selectBiddingAgencyDetailInfo(queryDetailIfo);
    }
}
