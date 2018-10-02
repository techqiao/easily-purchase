package com.epc.web.client.remoteApi.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.expert.Handle.HandleExpert;
import com.epc.web.facade.purchaser.FacadePurchaserService;
import com.epc.web.facade.purchaser.dto.*;
import com.epc.web.facade.purchaser.handle.*;
import com.epc.web.facade.purchaser.vo.*;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

public class PurchaserHystrix implements FacadePurchaserService {

    @Override
    public Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleEmployee) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> enableOrDisablePurchaserEmployee(HandleTrustList trustList) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeRole(HandleTrustList trustList) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updatePurchaserEmployeeInfo(HandlePurchaserDto handlePurchaser) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PurchaserEmplyeeVo>> queryEmplyee(HandleEmployeeDto employeeDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createExpertUserInfo(HandleExpert handleExpert) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> completePurchaserExpertInfo(HandleExpertDto expertDto) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deletePurchaserExpert(HandleTrustList trustList) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<PurchaserExpertVo>> queryExperts(QueryExpertDto dto) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> createAgencyUserInfo(HandleAgnecy handleAgnecy) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updateAgencyDetail(HandleAgnecy handleAgnecy) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updateTrustListForAgency(HandleTrustList trustList) {
        return Result.hystrixError();
    }


    @Override
    public Result<List<PurchaserAgencyVo>> queryAgenciesByCriteria(QueryAgencyDto agencyDto) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> createSupplierByPurchaser(HandleSupplierDto handleOperator) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updateSupplierDetail(PurchaserHandleSupplierDto dto) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updateTrustListForSupplier(HandleTrustList trustList) {
        return Result.hystrixError();
    }


    @Override
    public Result<List<PurchaserSupplierVo>> querySupplierByCriterias(QuerySupplierDto supplierDto) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updatePurchaserDetail(HandleRegisterPurchaser handlePurchaser) {
        return Result.hystrixError();
    }


    @Override
    public Result<PurchaserEmplyeeVo> queryEmployeeDto(QueryDto dto) {
        return null;
    }

    @Override
    public Result<Boolean> updateRole(Long id, Integer role) {
        return Result.hystrixError();
    }


    @Override
    public Result<SupplierDetailVo> querySuppliersDto(QueryDto dto) {
        return Result.hystrixError();
    }


    @Override
    public Result<PurchaserExpertDetailVo> queryExpertDetailById(QueryDto dto) {
        return Result.hystrixError();
    }


    @Override
    public Result<PurchaserAgencyDetailVo> queryAgencyDetailById(QueryDto dto) {
        return Result.hystrixError();
    }


    @Override
    public Result<Boolean> updateExpertState(Long id, Integer state) {
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
