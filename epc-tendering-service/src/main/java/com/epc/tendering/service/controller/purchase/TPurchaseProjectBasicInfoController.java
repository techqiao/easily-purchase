package com.epc.tendering.service.controller.purchase;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.purchase.TPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.purchase.FacadeTPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : 采购项目
 * <p>Date : 2018-09-18 19:05
 * <p>@Author : wjq
 */
@RestController
public class TPurchaseProjectBasicInfoController extends BaseController implements FacadeTPurchaseProjectBasicInfoService {
    @Autowired
    private TPurchaseProjectBasicInfoService tPurchaseProjectBasicInfoService;

    @Override
    public Result<Boolean> handlePurchaseProjectBasicInfo(@RequestBody HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub) {
        return tPurchaseProjectBasicInfoService.handlePurchaseProjectBasicInfo(handlePurchaseProjectBasicInfoSub);
    }

    @Override
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(Long purchaseProjectId) {
        return tPurchaseProjectBasicInfoService.getPurchaseProjectBasicInfo(purchaseProjectId);
    }

    @Override
    public Result<Map<String, Object>> getPurchaseProjectList(@RequestBody QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        PageHelper.startPage(queryPurchaseBasicInfoVO.getPage(),queryPurchaseBasicInfoVO.getRows());
        Result<List<PurchaseProjectBasicInfoVO>> purchaseProjectList = tPurchaseProjectBasicInfoService.getPurchaseProjectList(queryPurchaseBasicInfoVO);
        PageInfo<PurchaseProjectBasicInfoVO> pageInfo = new PageInfo<>(purchaseProjectList.getData());
        return Result.success(getDataTable(pageInfo));
    }

    @Override
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectListOfficialNetwork(@RequestBody QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        return tPurchaseProjectBasicInfoService.getPurchaseProjectList(queryPurchaseBasicInfoVO);
    }

}
