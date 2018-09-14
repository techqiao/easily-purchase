package com.epc.web.facade.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FacadePurchaserService {

    /**
     * 注册 采购人员
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "createPurchaseBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaseBasicInfo(@RequestBody HandlePurchaser handleOperator);
    /**
     * 采购人员注册供应商
     * @param handleSupplierDetail
     * @return
     */
    @PostMapping(value = "createSupplierByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDetail handleSupplierDetail);

    /**
     * 采购人员注册专家
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "createExpertByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createExpertByPurchaser(@RequestBody HandleExpert handleOperator);

    /**
     * 采购人员注册代理机构
     * @param handleOperator
     * @return
     */
    @PostMapping(value = "createAgencyByPurchaser", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createAgencyByPurchaser(@RequestBody HandleAgnecy handleOperator);

    /**
     * 完善采购人信息
     * @param handlePurchaser
     * @return
     */
    @PostMapping(value = "updatePurchaserDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updatePurchaserDetail(@RequestBody HandlePurchaser handlePurchaser);

    /**
     * 完善代理机构信息
     * @param handleAgnecy
     * @return
     */
    @PostMapping(value = "updateAgencyDetail", consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy);
}
