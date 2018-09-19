package com.epc.web.service.controller.purchaser;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.handle.HandPurchaserAttachment;
import com.epc.web.facade.purchaser.handle.HandleRegisterPurchaser;
import com.epc.web.service.service.purchaser.PurchaserService;
import com.epc.web.facade.expert.handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.purchaser.handle.HandleAgnecy;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description : 供应商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public  class PurchaserController implements FacadePurchaserService {

    @Autowired
    PurchaserService purchaserService;

    /**
     * 新增采购人员
     */
    @Override
    public Result<Boolean> createPurchaseBasicInfo(@RequestBody HandlePurchaser handleOperator) {
        return purchaserService.createPurchaserUserInfo(handleOperator,Const.Role.ROLE_CUSTOMER);
    }

    /**
     * 采购人 添加 供应商
     */
    @Override
    public Result<Boolean> createSupplierByPurchaser(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return purchaserService.createSupplierByPurchaser(handleSupplierDetail);
    }


    /**
     * 采购人 添加 专家
     */
    @Override
    public Result<Boolean> createExpertByPurchaser(@RequestBody HandleExpert handleExpert) {
        return purchaserService.createExpertUserInfo(handleExpert);
    }

    /**
     * 采购人 添加 代理机构
     */
    @Override
    public Result<Boolean> createAgencyByPurchaser(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserService.createAgencyUserInfo(handleAgnecy);
    }

    /**
     * 完善 采购人信息
     * @param handlePurchaser
     * @return
     */
    @Override
    public Result<Boolean> updatePurchaserDetail(@RequestBody HandlePurchaser handlePurchaser) {
        return purchaserService.updatePurchaserDetail(handlePurchaser);
    }

    /**
     * 完善 代理机构信息
     * @param handleAgnecy
     * @return
     */
    @Override
    public Result<Boolean> updateAgencyDetail(@RequestBody HandleAgnecy handleAgnecy) {
        return purchaserService.updateAgencyDetail(handleAgnecy);
    }

    @Override
    public Result registerPurchaser(HandleRegisterPurchaser purchaser) {
        return purchaserService.registerPurchaser(purchaser);
    }

    @Override
    public Result allEmployee(Long purchaserId) {
        return purchaserService.allEmployee(purchaserId);
    }

    @Override
    public Result findEmployeeByName(String fuzzyName,Long purchaseId) {
        return purchaserService.findEmployeeByName(fuzzyName,purchaseId);
    }

    @Override
    public Result updateEmployeeState(String cellphone, Integer state) {
        return purchaserService.updateEmployeeState(cellphone,state);
    }

    @Override
    public Result updateEmployeeStateById(Long id, Integer state) {
        return purchaserService.updateEmployeeState(id,state);
    }

    @Override
    public Result queryEmployee(String cellphone) {
        return purchaserService.queryEmployee(cellphone);
    }

    @Override
    public Result queryEmployee(Long id) {
        return purchaserService.queryEmployee(id);
    }


    @Override
    public Result queryEmplyee(HandleEmployeeDto employeeDto) {
        return purchaserService.queryEmplyee(employeeDto);
    }


    @Override
    public Result updateRole(Long id, Integer role) {
        return purchaserService.updateRole(id,role);
    }

    @Override
    public Result queryAllSuppliers(Long purchaseId) {
        return purchaserService.queryAllSuppliers(purchaseId);
    }

    @Override
    public Result querySuppliers(String fuzzyName, Long purchaseId) {
        return purchaserService.querySuppliers(fuzzyName,purchaseId);
    }

    @Override
    public Result querySuppliers(Long id) {
        return purchaserService.querySuppliers(id);
    }

    @Override
    public Result updateSuppliers(HandPurchaserAttachment attachment) {
        return purchaserService.updateSuppliers(attachment);
    }

    @Override
    public Result queryExperts(HandleExpertDto dto) {
        return purchaserService.queryExperts(dto);
    }

    @Override
    public Result updateExpertState(Long id, Integer state) {
        return purchaserService.updateExpertState(id,state);
    }

}
