package com.epc.administration.client.controller.biddingagency;


import com.epc.administration.client.remoteapi.biddingagency.BiddingAgencyClient;
import com.epc.administration.facade.operator.handle.UserBasicInfo;
import com.epc.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
}
