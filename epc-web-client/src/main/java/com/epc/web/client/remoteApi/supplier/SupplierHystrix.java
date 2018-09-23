package com.epc.web.client.remoteApi.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;

import java.util.List;


/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-13  15:10
 * <p>@author : donghuan
 */
public class SupplierHystrix implements FacadeTSupplierBasicInfoService {

    @Override
    public Result<Boolean> registerSupplier(HandleSupplierDetail handleSupplierDetail) {
        return Result.hystrixError();
    }

    /**
     * 根据员工的id来删除员工
     */
    @Override
    public Result<Boolean> deleteSupplierEmployeeById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return Result.hystrixError();
    }

    /**
     * 根据员工的id来查询基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierBasicById(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return Result.hystrixError();
    }

    /**
     * 员工查询 公司详情
     */
    @Override
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<SupplierBasicInfoVO> findByName(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> forgetPassword(HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> createSupplierEmployee(HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateSupplierEmployeeById(HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return Result.hystrixError();
    }

    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> insertCompleteSupplierInfo(RoleDetailInfo roleDetailInfo) {
        return Result.hystrixError();
    }

}
