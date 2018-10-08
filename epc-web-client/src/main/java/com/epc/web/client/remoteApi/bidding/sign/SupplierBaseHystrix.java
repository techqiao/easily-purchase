package com.epc.web.client.remoteApi.bidding.sign;

import com.epc.common.Result;
import com.epc.web.facade.loginuser.dto.LoginUser;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierId;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.query.QuerywithPageHandle;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;

import java.util.List;
import java.util.Map;

public class SupplierBaseHystrix implements FacadeTSupplierBasicInfoService {


    @Override
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierBasicById handleFindSupplierBasicById) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return Result.hystrixError();
    }

    @Override
    public Result<RoleDetailInfo> findSupplierDetailByEmployee(HandleFindSupplierBasicById handleFindSupplierBasicById) {
        return Result.hystrixError();
    }

    @Override
    public Result<RoleDetailInfo> findSupplierByBossId(HandleFindSupplierBasicById handleFindSupplierBasicById) {
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

    @Override
    public Result<Boolean> updateSupplierEmployeeRoleById(HandleOperatorRole handleOperatorRole) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeStateById(HandleOperatorState handleOperatorState) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forgetPasswordSupplier(HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleSupplierIdAndName handleSupplierIdAndName) {
        return Result.hystrixError();
    }

    @Override
    public Result<Map<String, Object>> querySupplierProject(QuerywithPageHandle querywithPageHandle) {
        return Result.hystrixError();
    }
}
