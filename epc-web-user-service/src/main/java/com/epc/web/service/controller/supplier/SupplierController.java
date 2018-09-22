package com.epc.web.service.controller.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 供应商
 * @author donghuan
 */
@RestController
public class SupplierController implements FacadeTSupplierBasicInfoService {

    @Autowired
    private TSupplierBasicInfoService tSupplierBasicInfoService;

    /**
     * 供应商注册
     */
    @Override
    public Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return tSupplierBasicInfoService.registerSupplier(handleSupplierDetail);
    }

    /**
     * 根据员工的id来查询基本信息
     */
    @Override
    public Result<SupplierBasicInfoVO> fingSupplierBasicById(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo){
        return tSupplierBasicInfoService.fingSupplierBasicById(handleFindSupplierByInfo);
    }


    /**
     * 根据电话来查找一条记录,返回一个记录
     */
    @Override
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return tSupplierBasicInfoService.findSupplierByCellphone(handleFindSupplierByInfo);
    }

    /**
     * 根据名字或者电话来得到这个人的信息
     */
    @Override
    public Result<SupplierBasicInfoVO> findByName(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return tSupplierBasicInfoService.findByName(handleFindSupplierByInfo);
    }

    /**
     *  忘记密码
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return tSupplierBasicInfoService.forgetPassword(handleSupplierForgetPassword);
    }

    /**
     * 供应商添加员工
     */
    @Override
    public Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return tSupplierBasicInfoService.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**
     * 通过供应商员工id更新一条信息
     */
    @Override
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return tSupplierBasicInfoService.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

    /**
     * 根据员工的姓名来模糊查询出一个符合要求的列表
     */
    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleFindSupplierByInfo handleFindSupplierByInfo) {
        return tSupplierBasicInfoService.querySupplierEmployeeAll(handleFindSupplierByInfo);
    }

    /**
     * 完善供应商信息
     */
    @Override
    public Result<Boolean> insertCompleteSupplierInfo(@RequestBody RoleDetailInfo roleDetailInfo) {
        return tSupplierBasicInfoService.insertCompleteSupplierInfo(roleDetailInfo);
    }


}