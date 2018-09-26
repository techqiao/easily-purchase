package com.epc.web.client.controller.terdering.bid;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleExpertSign;
import com.epc.web.client.remoteApi.terdering.bid.ExpertSignClient;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:52
 * <p>@Author : wjq
 */
@Api(value = "开标记录服务",tags="开标记录服务")
@RestController
@RequestMapping(value = "/record", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ExpertSignController extends BaseController {
    @Autowired
    private ExpertSignClient expertSignClient;

    @ApiOperation(value = "评标专家签到")
    @PostMapping(value = "insertExpertSign", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertExpertSign(@RequestBody ClientHandleExpertSign clientHandleExpertSign){
        HandleExpertSign handleExpertSign = new HandleExpertSign();
        BeanUtils.copyProperties(clientHandleExpertSign, handleExpertSign);
        handleExpertSign.setOperateId(getLoginUser().getUserId());
        return expertSignClient.insertExpertSign(handleExpertSign);
    }

    @ApiOperation(value = "设为组长")
    @PostMapping(value = "handleExpert", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> handleExpert(@RequestParam(value = "id") Long id){
        return expertSignClient.handleExpert(id);
    }

}
