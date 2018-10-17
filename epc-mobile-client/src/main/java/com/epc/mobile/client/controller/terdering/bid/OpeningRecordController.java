package com.epc.mobile.client.controller.terdering.bid;

import com.epc.common.Result;

import com.epc.mobile.client.controller.common.BaseController;
import com.epc.mobile.client.controller.terdering.bid.handle.ClientHandleOpeningRecord;
import com.epc.mobile.client.controller.terdering.bid.query.ClientQueryBidsDTO;
import com.epc.mobile.client.remoteApi.terdering.bid.OpeningRecordClient;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 15:17
 * <p>@Author : wjq
 */
@Api(value = "开标服务",tags="开标服务")
@RestController
@RequestMapping(value = "/record", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpeningRecordController extends BaseController {

    @Autowired
    private OpeningRecordClient openingRecordClient;

    @ApiOperation(value = "开标确认")
    @PostMapping(value = "insertOpeningRecord")
    public Result<Boolean> insertOpeningRecord(@RequestBody List<ClientHandleOpeningRecord> clientHandleOpeningRecord){
        List<HandleOpeningRecord> recordList = new ArrayList<>();
        for (ClientHandleOpeningRecord item : clientHandleOpeningRecord) {
            HandleOpeningRecord pojo = new HandleOpeningRecord();
            BeanUtils.copyProperties(item,pojo);
            pojo.setOperateId(getLoginUser().getUserId());
            recordList.add(pojo);
        }
        return openingRecordClient.insertOpeningRecord(recordList);
    }

    @ApiOperation(value = "查询开标前置条件")
    @PostMapping(value = "getOpeningRecordList")
    public Result<Map<String, Object>> getOpeningRecordList(@RequestBody ClientQueryBidsDTO clientQueryBidsDTO){
        QueryBidsDTO queryBidsDTO = new QueryBidsDTO();
        BeanUtils.copyProperties(clientQueryBidsDTO,queryBidsDTO);
        return openingRecordClient.getOpeningRecordList(queryBidsDTO);
    }

}
