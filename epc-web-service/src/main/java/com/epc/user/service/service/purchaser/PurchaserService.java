package com.epc.user.service.service.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;

public interface PurchaserService {
    /**
     * 新增采购人
     */

    Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType);

    /**
     * 添加运营商-采购人关系
     * @param handleOperator
     * @return
     */
    Result<Boolean> createOperatePurchaser(HandlePurchaser handleOperator);

    /**
     * 添加运营商(私库)
     * @param handleOperator
     * @return
     */
    Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleOperator);

    /**
     * 添加专家(私库)
     * @param handleExpert
     * @return
     */
    Result<Boolean> createExpertUserInfo(HandleExpert handleExpert);

    /**
     * 添加代理机构(私库)
     * @param handleAgnecy
     * @return
     */
    Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy);


    /**
     * 完善采购人信息detail
     * @param handlePurchaser
     * @return
     */
    Result<Boolean> updatePurchaserDetail(HandlePurchaser handlePurchaser);
    /**
     * 完善供货商信息detail
     * @param HandleSupplierDetail
     * @return
     */
    Result<Boolean> updateSupplierDetail(HandleSupplierDetail HandleSupplierDetail);

    /**
     * 完善代理机构detail
     * @param handleAgnecy
     * @return
     */
    Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy);
}
