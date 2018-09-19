package com.epc.web.client.controller.terdering.purchase;

import com.epc.common.Result;
import com.epc.web.client.controller.terdering.purchase.handle.ClientHandlePurchaseProjectBasicInfo;
import com.epc.web.client.controller.terdering.purchase.vo.ClientQueryPurchaseBasicInfoVO;
import com.epc.web.client.remoteApi.terdering.purchase.PurchaseProjectClient;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfo;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 17:33
 * <p>@Author : wjq
 */
@Api(value = "采购项目服务", tags = {"采购项目服务"})
@RestController
@RequestMapping(value = "/purchase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PurchaseProjectBasicInfoController {

    @Autowired
    private PurchaseProjectClient purchaseProjectClient;

    @ApiOperation(value = "新增|修改采购项目")
    @PostMapping(value = "handlePurchaseProjectBasicInfo")
    public Result<Boolean> handlePurchaseProjectBasicInfo(@RequestBody ClientHandlePurchaseProjectBasicInfo clientHandlePurchaseProjectBasicInfo) {
        HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub = new HandlePurchaseProjectBasicInfoSub();
        BeanUtils.copyProperties(clientHandlePurchaseProjectBasicInfo, handlePurchaseProjectBasicInfoSub);
        // 经办人
        if (clientHandlePurchaseProjectBasicInfo.getAgentId() != null) {
            //TODO 拿到用户信息
        }
        // 审核人
        if (clientHandlePurchaseProjectBasicInfo.getAuditorId() != null) {
            //TODO 拿到用户信息
        }
        return purchaseProjectClient.handlePurchaseProjectBasicInfo(handlePurchaseProjectBasicInfoSub);
    }

    @ApiOperation(value = "查询采购项目详情")
    @GetMapping(value = "getPurchaseProjectBasicInfo")
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(@RequestParam Long purchaseProjectId) {
        return purchaseProjectClient.getPurchaseProjectBasicInfo(purchaseProjectId);
    }

    @ApiOperation(value = "查询采购项目列表")
    @PostMapping(value = "getPurchaseProjectList")
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectList(@RequestBody ClientQueryPurchaseBasicInfoVO clientQueryPurchaseBasicInfoVO) {
        QueryPurchaseBasicInfoVO pojo = new QueryPurchaseBasicInfoVO();
        BeanUtils.copyProperties(clientQueryPurchaseBasicInfoVO, pojo);
        return purchaseProjectClient.getPurchaseProjectList(pojo);
    }


}
