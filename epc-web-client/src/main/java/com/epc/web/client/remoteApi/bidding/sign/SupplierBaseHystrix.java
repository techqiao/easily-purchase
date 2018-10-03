package com.epc.web.client.remoteApi.bidding.sign;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierId;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;

import java.util.List;

public class SupplierBaseHystrix implements FacadeTSupplierBasicInfoService {
    @Override
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> addPasswordSupplierLogin(HandleSupplierDetail handleSupplierDetail) {
        return null;
    }

    @Override
    public Result<Boolean> addPasswordSupplier(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

//    @Override
//    public Result<Boolean> deleteSupplierEmployeeById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//        return Result.hystrixError();
//    }
//
//    @Override
//    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//        return Result.hystrixError();
//    }
//
//    @Override
//    public Result<Boolean> updateSupplierEmployeeByisDeleted(HandleSupplierEmployeeByisDeleted handleSupplierEmployeeByisDeleted) {
//        return Result.hystrixError();
//    }

    @Override
    public Result<Boolean> updateSupplierEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        return null;
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeStateById(HandleOperatorState handleOperatorState) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forgetPasswordSupplier(HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return null;
    }
//
//    @Override
//    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//        return Result.hystrixError();
//    }
//
//    @Override
//    public Result<Boolean> findSupplierRecordByCellphone(HandleSupplierRecordByCellphone handleSupplierByCellphone) {
//        return Result.hystrixError();
//    }
//
//    @Override
//    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//        return Result.hystrixError();
    //}


//    @Override
//    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {
//        return Result.hystrixError();    }

    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleSupplierIdAndName handleSupplierIdAndName) {
        return null;
    }

    @Override
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return Result.hystrixError();    }

    @Override
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleSupplierId handleSupplierId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return Result.hystrixError();    }

    @Override
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleSupplierId handleSupplierId) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> findSupplierRecordByCellphone(HandleSupplierCellphone handleSupplierCellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleSupplierCellphone handleSupplierCellphone) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeByisDeleted(HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> deleteSupplierEmployeeById(HandleSupplieIsDeleted handleSupplieIsDeleted) {
        return Result.hystrixError();
    }

//    @Override
//    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//        return Result.hystrixError();
//    }
//
//    @Override
//    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(HandleFindSupplierByInfo handleFindSupplierByInfo) {
//        return Result.hystrixError();
//    }

    @Override
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {
        return Result.hystrixError();
    }
}
