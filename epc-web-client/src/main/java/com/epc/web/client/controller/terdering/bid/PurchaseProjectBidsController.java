package com.epc.web.client.controller.terdering.bid;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.bid.handle.ClientHandleBidsBasicInfo;
import com.epc.web.client.controller.terdering.bid.query.ClientQueryBidsDTO;
import com.epc.web.client.remoteApi.terdering.bid.BidClient;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoSubVO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : 采购项目标段服务
 * <p>Date : 2018-09-19 11:10
 * <p>@Author : wjq
 */
@Api(value = "采购项目标段服务",tags = {"采购项目标段服务"})
@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaseProjectBidsController extends BaseController {
    @Autowired
    private BidClient bidClient;

    @ApiOperation(value = "新增|修改|删除标段")
    @PostMapping(value="/handleBidsBasicInfo")
    public Result<Boolean> handleBidsBasicInfo(@RequestBody ClientHandleBidsBasicInfo clientHandleBidsBasicInfo){
        HandleBidsBasicInfo handleBidsBasicInfo = new HandleBidsBasicInfo();
        BeanUtils.copyProperties(clientHandleBidsBasicInfo,handleBidsBasicInfo);
        handleBidsBasicInfo.setOperateId(getLoginUser().getUserId());
        handleBidsBasicInfo.setCreator(getLoginUser().getName());
        return bidClient.handleBidsBasicInfo(handleBidsBasicInfo);
    }


    @ApiOperation(value = "查询标段详情")
    @GetMapping(value="/getBidsDetailInfo")
    public Result<BidsBasicInfoSubVO> getBidsDetailInfo(@ApiParam(value = "标段ID") @RequestParam Long bidId){
        Validate.notNull(bidId);
        return bidClient.getBidsDetailInfo(bidId);
    }


    @ApiOperation(value = "查询标段列表")
    @PostMapping(value="/getBidsList")
    public Result<List<BidsBasicInfoVO>> getBidsList(@RequestBody ClientQueryBidsDTO clientQueryBidsDTO){
        Validate.notNull(clientQueryBidsDTO.getPurchaseProjectId());
        QueryBidsDTO queryBidsDTO = new QueryBidsDTO();
        BeanUtils.copyProperties(clientQueryBidsDTO, queryBidsDTO);
        return bidClient.getBidsList(queryBidsDTO);
    }


}
