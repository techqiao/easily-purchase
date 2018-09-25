package com.epc.web.client.remoteApi.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.purchaser.dto.HandleAgencyDto;
import com.epc.web.facade.purchaser.dto.HandleEmployeeDto;
import com.epc.web.facade.purchaser.dto.HandleExpertDto;
import com.epc.web.facade.purchaser.dto.HandleSupplierDto;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.PurchaserAgencyVo;
import com.epc.web.facade.purchaser.vo.PurchaserSupplierVo;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;

import java.util.List;

public class PurchaserHystrix implements FacadePurchaserService {
    @Override
    public Result<Boolean> createPurchaseBasicInfo(HandlePurchaser handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createExpertByPurchaser(HandleExpert handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createAgencyByPurchaser(HandleAgnecy handleOperator) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserDetail(HandleRegisterPurchaser handlePurchaser) {
        return null;
    }

    @Override
    public Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierDetail(PurchaserHandleSupplierDto dto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> completePurchaserExpertInfo(HandleExpertDto expertDto) {
        return Result.hystrixError();
    }

    @Override
    public Result registerPurchaser(HandleRegisterPurchaser purchaser) {
        return Result.hystrixError();
    }

    @Override
    public Result allEmployee(Long purchaserId) {
        return Result.hystrixError();
    }

    @Override
    public Result findEmployeeByName(String fuzzyName, Long purchaseId) {
        return Result.hystrixError();
    }


    @Override
    public Result updateEmployeeState(String cellphone, Integer state) {
        return Result.hystrixError();
    }

    @Override
    public Result updateEmployeeStateById(Long id, Integer state) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployee(String cellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployee(Long id) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmplyee(HandleEmployeeDto employeeDto) {
        return Result.hystrixError();
    }

    @Override
    public Result updateRole(Long id, Integer role) {
        return Result.hystrixError();
    }

    @Override
    public Result queryAllSuppliers(Long purchaseId) {
        return Result.hystrixError();
    }

    @Override
    public Result querySuppliers(String fuzzyName, Long purchaseId) {
        return Result.hystrixError();
    }

    @Override
    public Result querySuppliers(Long id) {
        return Result.hystrixError();
    }

    @Override
    public Result updateSuppliers(HandPurchaserAttachment attachment) {
        return Result.hystrixError();
    }

    @Override
    public Result queryExperts(HandleExpertDto dto) {
        return Result.hystrixError();
    }

    @Override
    public Result updateExpertState(Long id, Integer state) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(HandleAgencyDto agencyDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(HandleSupplierDto supplierDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserAgency(HandleAgencyDto agencyDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserExpert(HandleExpertDto expertDto) {
        return Result.hystrixError();
    }
}
