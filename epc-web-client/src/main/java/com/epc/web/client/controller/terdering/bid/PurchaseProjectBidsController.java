package com.epc.web.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleBidsBasicInfo;
import com.epc.web.client.remoteApi.terdering.bid.BidClient;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
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
 * <p>Description : 采购项目标段服务
 * <p>Date : 2018-09-19 11:10
 * <p>@Author : wjq
 */
@Api(value = "采购项目标段服务",tags = {"采购项目标段服务"})
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaseProjectBidsController {
    @Autowired
    private BidClient bidClient;

    @ApiOperation(value = "新增|修改标段")
    @PostMapping(value="/handleBidsBasicInfo")
    public Result<Boolean> handleBidsBasicInfo(@RequestBody ClientHandleBidsBasicInfo clientHandleBidsBasicInfo){
        HandleBidsBasicInfo handleBidsBasicInfo = new HandleBidsBasicInfo();
        BeanUtils.copyProperties(clientHandleBidsBasicInfo,handleBidsBasicInfo);
        return bidClient.handleBidsBasicInfo(handleBidsBasicInfo);
    }
}
