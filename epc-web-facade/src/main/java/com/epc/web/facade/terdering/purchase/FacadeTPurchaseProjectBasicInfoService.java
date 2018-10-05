package com.epc.web.facade.terdering.purchase;

import com.epc.common.Result;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : 采购项目服务
 * <p>Date : 2018-09-18 17:39
 * <p>@Author : wjq
 */
public interface FacadeTPurchaseProjectBasicInfoService {
    /**
     * 新增|修改|删除采购项目
     * @param handlePurchaseProjectBasicInfoSub
     * @return
     */
    @PostMapping(value = "handlePurchaseProjectBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handlePurchaseProjectBasicInfo(@RequestBody HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub);

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
    Result<Map<String, Object>> getPurchaseProjectList(@RequestBody QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO);

    /**
     * 官网采购项目列表
     * @param queryPurchaseBasicInfoVO
     * @return
     */
    @PostMapping(value = "getPurchaseProjectListOfficialNetwork", consumes = "application/json; charset=UTF-8")
    Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectListOfficialNetwork(@RequestBody QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO);

}
