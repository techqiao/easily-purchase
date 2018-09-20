package com.epc.web.service.controller.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import com.epc.web.service.service.supplier.TSupplierUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierControllerImpl implements FacadeTSupplierBasicInfoService {

    @Autowired
    private TSupplierBasicInfoService tSupplierBasicInfoService;

    @Autowired
    private TSupplierUserService tSupplierUserService;


    //供应商注册
    @Override
    public Result<Boolean> registerSupplier(@RequestBody HandleSupplierDetail handleSupplierDetail) {
        return tSupplierUserService.registerSupplier(handleSupplierDetail);
    }

    //登陆
    @Override
    public Result<SupplierBasicInfoVO> login(@RequestBody String cellphone, String password) {
        return tSupplierUserService.login(cellphone,password);
    }

    //根据名字或者电话来得到这个人的信息
    @Override
    public Result<SupplierDetailInfoVO> findByName(@RequestParam String name, String cellphone) {
        return tSupplierUserService.findByName(name,cellphone);
    }

    //忘记密码
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleSupplierForgetPassword handleSupplierForgetPassword) {
        return tSupplierUserService.forgetPassword(handleSupplierForgetPassword);
    }


    //供应商添加员工
    @Override
    public Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee) {
        return tSupplierBasicInfoService.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    //通过供应商员工id更新一条信息
    @Override
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById) {
        return tSupplierBasicInfoService.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

   //根据员工的姓名来模糊查询出一个符合要求的列表
    @Override
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody HandleSupplierFindAllByName handleSupplierFindAllByName) {
        return tSupplierBasicInfoService.querySupplierEmployeeAll(handleSupplierFindAllByName);
    }


}
