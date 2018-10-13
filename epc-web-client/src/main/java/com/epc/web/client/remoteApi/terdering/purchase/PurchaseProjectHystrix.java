package com.epc.web.client.remoteApi.terdering.purchase;

import com.epc.common.Result;
import com.epc.web.facade.terdering.purchase.FacadeTPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.FlowVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 18:57
 * <p>@Author : wjq
 */
public class PurchaseProjectHystrix implements FacadeTPurchaseProjectBasicInfoService {
    @Override
    public Result<Boolean> handlePurchaseProjectBasicInfo(HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub) {
        return Result.hystrixError();
    }

    @Override
    public Result<FlowVO> getFlowByProcurementProjectId(Long procurementProjectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(Long purchaseProjectId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Map<String, Object>> getPurchaseProjectList(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectListOfficialNetwork(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        return Result.hystrixError();
    }

}
