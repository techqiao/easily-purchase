package com.epc.web.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandOpeningRecordPublicity;
import com.epc.web.client.remoteApi.terdering.bid.OpeningRecordPublicityClient;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
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
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 18:22
 * <p>@Author : wjq
 */
@Api(value = "公示开标记录服务",tags="公示开标记录服务")
@RestController
@RequestMapping(value = "/record", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpeningRecordPublicityController extends BaseController {
    @Autowired
    private OpeningRecordPublicityClient openingRecordPublicityClient;

    @ApiOperation(value = "处理公示开标记录")
    @PostMapping(value = "insertOpeningRecordPublicity", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertOpeningRecordPublicity(@RequestBody ClientHandOpeningRecordPublicity clientHandOpeningRecordPublicity){
        HandOpeningRecordPublicity handOpeningRecordPublicity = new HandOpeningRecordPublicity();
        BeanUtils.copyProperties(clientHandOpeningRecordPublicity, handOpeningRecordPublicity);
        handOpeningRecordPublicity.setOperateId(getLoginUser().getUserId());
        return openingRecordPublicityClient.insertOpeningRecordPublicity(handOpeningRecordPublicity);
    }




}