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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

public class PurchaserHystrix implements FacadePurchaserService {
    @Override
    public Result<Boolean> createPurchaseBasicInfo(HandlePurchaser handleOperator) {
        return Result.hystrixError();
    }
    @Override
    public Result<Boolean> enableOrDisablePurchaserEmployee(HandleTrustList trustList){
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeRole(HandleTrustList trustList) {
        return Result.hystrixError();
    }
    @Override
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDto handleSupplierDetail) {
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

//    @Override
//    public Result<Boolean> updatePurchaserDetail(HandlePurchaser handlePurchaser) {
//        return null;
//    }

    @Override
    public Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy) {
        return null;
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
    public Result allEmployee(HashMap<String,Long> map) {
        return Result.hystrixError();
    }

    @Override
    public Result findEmployeeByName(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result updateEmployeeState(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result updateEmployeeStateById(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployeeByCellphone(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmployeeById(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result queryEmplyee(HandleEmployeeDto employeeDto) {
        return Result.hystrixError();
    }

    @Override
    public Result updateRole(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result queryAllSuppliers(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result querySuppliersByName(HashMap<String, Object> map) {
        return null;
    }

    @Override
    public Result querySuppliersById(HashMap<String, Object> map) {
        return Result.hystrixError();
    }

    @Override
    public Result updateSuppliers(HandleSupplierDto attachment) {
        return Result.hystrixError();
    }

    @Override
    public Result queryExperts(HandleExpertDto dto) {
        return Result.hystrixError();
    }

    @Override
    public Result updateExpertState(HashMap<String, Object> map) {
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

    @Override
    public Result queryEmployee(Long userId) {
        return Result.hystrixError();
    }
}
