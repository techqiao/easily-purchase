package com.epc.tendering.service.controller.purchase;

import com.epc.common.Result;
import com.epc.tendering.service.service.purchase.TPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.purchase.FacadeTPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfo;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : 采购项目
 * <p>Date : 2018-09-18 19:05
 * <p>@Author : wjq
 */
@RestController
public class TPurchaseProjectBasicInfoController implements FacadeTPurchaseProjectBasicInfoService {
    @Autowired
    private TPurchaseProjectBasicInfoService tPurchaseProjectBasicInfoService;

    @Override
    public Result<Boolean> handlePurchaseProjectBasicInfo(HandlePurchaseProjectBasicInfo handlePurchaseProjectBasicInfo) {
        return tPurchaseProjectBasicInfoService.handlePurchaseProjectBasicInfo(handlePurchaseProjectBasicInfo);
    }

    @Override
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(Long purchaseProjectId) {
        return tPurchaseProjectBasicInfoService.getPurchaseProjectBasicInfo(purchaseProjectId);
    }

    @Override
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectList(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        return tPurchaseProjectBasicInfoService.getPurchaseProjectList(queryPurchaseBasicInfoVO);
    }

}
