package com.epc.web.service.controller.supplier;

import com.epc.common.Result;
import com.epc.web.facade.supplier.FacadeTSupplierBasicInfoService;
import com.epc.web.facade.supplier.handle.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.handle.HandlerSupplierAddEmployee;
import com.epc.web.facade.supplier.handle.HandlerUpdateSupplierEmployeeById;
import com.epc.web.service.domain.supplier.TSupplierBasicInfo;
import com.epc.web.service.service.supplier.TSupplierBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class SupplierControllerImpl implements FacadeTSupplierBasicInfoService {

    @Autowired
    TSupplierBasicInfoService tSupplierBasicInfoService;

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
    public Result<List<TSupplierBasicInfo>> querySupplierEmployeeAll(@RequestBody HandleSupplierFindAllByName handleSupplierFindAllByName) {
        return tSupplierBasicInfoService.querySupplierEmployeeAll(handleSupplierFindAllByName);
    }


}
