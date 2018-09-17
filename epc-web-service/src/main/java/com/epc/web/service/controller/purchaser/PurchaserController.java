package com.epc.web.service.controller.purchaser;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public class PurchaserController implements FacadePurchaserService {

    @Autowired
    PurchaserService purchaserService;

    /**
     * 新增采购人员
     */
    @Override
    public Result<Boolean> createPurchaseBasicInfo(HandlePurchaser handleOperator) {
        return purchaserService.createPurchaserUserInfo(handleOperator,Const.Role.ROLE_CUSTOMER);
    }

    /**
     * 采购人 添加 供应商
     */
    @Override
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleSupplierDetail) {
        return purchaserService.createSupplierByPurchaser(handleSupplierDetail);
    }


    /**
     * 采购人 添加 专家
     */
    @Override
    public Result<Boolean> createExpertByPurchaser(HandleExpert handleExpert) {
        return purchaserService.createExpertUserInfo(handleExpert);
    }

    /**
     * 采购人 添加 代理机构
     */
    @Override
    public Result<Boolean> createAgencyByPurchaser(HandleAgnecy handleAgnecy) {
        return purchaserService.createAgencyUserInfo(handleAgnecy);
    }

    /**
     * 完善 采购人信息
     * @param handlePurchaser
     * @return
     */
    @Override
    public Result<Boolean> updatePurchaserDetail(HandlePurchaser handlePurchaser) {
        return purchaserService.updatePurchaserDetail(handlePurchaser);
    }

    /**
     * 完善 代理机构信息
     * @param handleAgnecy
     * @return
     */
    @Override
    public Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy) {
        return purchaserService.updateAgencyDetail(handleAgnecy);
    }

}
