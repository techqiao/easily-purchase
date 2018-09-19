package com.epc.web.facade.terdering.purchase;

import com.epc.common.Result;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfo;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description : 采购项目服务
 * <p>Date : 2018-09-18 17:39
 * <p>@Author : wjq
 */
public interface FacadeTPurchaseProjectBasicInfoService {
    /**
     * 新增|修改采购项目
     * @param handlePurchaseProjectBasicInfo
     * @return
     */
    @PostMapping(value = "handlePurchaseProjectBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handlePurchaseProjectBasicInfo(@RequestBody HandlePurchaseProjectBasicInfo handlePurchaseProjectBasicInfo);

    /**
     * 查询采购项目详情
     * @param purchaseProjectId
     * @return
     */
    @GetMapping(value = "getPurchaseProjectBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(@RequestParam(value = "purchaseProjectId") Long purchaseProjectId);


    /**
     * 采购项目列表
     * @param queryPurchaseBasicInfoVO
     * @return
     */
    @PostMapping(value = "getPurchaseProjectList", consumes = "application/json; charset=UTF-8")
    Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectList(@RequestBody QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO);
}
