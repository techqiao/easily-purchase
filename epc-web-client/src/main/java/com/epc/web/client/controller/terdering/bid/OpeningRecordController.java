package com.epc.web.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleOpeningRecord;
import com.epc.web.client.remoteApi.terdering.bid.OpeningRecordClient;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 15:17
 * <p>@Author : wjq
 */
@Api(value = "开标记录服务",tags="开标记录服务")
@RestController
@RequestMapping(value = "/record", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OpeningRecordController extends BaseController {

    @Autowired
    private OpeningRecordClient openingRecordClient;

    @ApiOperation(value = "新增开标记录")
    @PostMapping(value = "insertOpeningRecord")
    public Result<Boolean> insertOpeningRecord(@RequestBody ClientHandleOpeningRecord clientHandleOpeningRecord){
        HandleOpeningRecord handleOpeningRecord = new HandleOpeningRecord();
        BeanUtils.copyProperties(clientHandleOpeningRecord, handleOpeningRecord);
        handleOpeningRecord.setOperateId(getLoginUser().getUserId());
        return openingRecordClient.insertOpeningRecord(handleOpeningRecord);
    }

    @ApiOperation(value = "查询开标前置条件")
    @GetMapping(value = "getOpeningRecordList")
    public Result<List<OpeningRecordVO>> getOpeningRecordList(Long purchaseProjectId){
        return openingRecordClient.getOpeningRecordList(purchaseProjectId);
    }

}
