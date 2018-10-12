package com.epc.tendering.service.service.purchase;

import com.epc.common.Result;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfo;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.FlowVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description : 采购项目接口
 * <p>Date : 2018-09-18 19:07
 * <p>@Author : wjq
 */
public interface TPurchaseProjectBasicInfoService {

    /**
     * 新增|修改采购项目
     * @param handlePurchaseProjectBasicInfoSub
     * @return
     */
    Result<Boolean> handlePurchaseProjectBasicInfo(HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub);


    /**
     * 查询采购项目详情
     * @param id
     * @return
     */
    Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(Long id);


    /**
     * 查询采购项目列表
     * @param queryPurchaseBasicInfoVO 动态过滤条件
     * @return
     */
    Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectList(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO);

    /**
     * 采购项目步骤
     * @param procurementProjectId
     * @return
     */
    Result<FlowVO> getFlowByProcurementProjectId(Long procurementProjectId);
}
