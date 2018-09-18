package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.supplier.handle.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.handle.HandlerSupplierAddEmployee;
import com.epc.web.facade.supplier.handle.HandlerUpdateSupplierEmployeeById;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "供应商服务")
@RestController
@RequestMapping(value = "/supplier",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController {

    @Autowired
    SupplierClient supplierClient;

    /**
    * @Description:    供应商添加员工
    * @Author:         donghuan
    * @param
    * @CreateDate:     16:35 2018/9/13
    * @UpdateUser:
    * @UpdateDate:     16:35 2018/9/13
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "供应商添加员工")
    @PostMapping(value="/createSupplierEmployee")
    public Result<Boolean> createSupplierEmployee(@RequestBody HandlerSupplierAddEmployee handlerSupplierAddEmployee){
        return supplierClient.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**
    * @Description:    供应商通过员工id来修改名字和手机号及状态是否可用
    * @Author:         donghuan
    * @param
    * @CreateDate:     11:10 2018/9/15
    * @UpdateUser:
    * @UpdateDate:     11:10 2018/9/15
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "供应商修改员工")
    @PostMapping(value="/updateSupplierEmployeeById")
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById){
        return supplierClient.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }


    /**
    * @Description:    根据员工姓名模糊查询
    * @Author:         donghuan
    * @param
    * @CreateDate:     11:11 2018/9/15
    * @UpdateUser:
    * @UpdateDate:     11:11 2018/9/15
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "根据员工姓名模糊查询",notes = "根据员工姓名模糊查询")
    @PostMapping(value="/createSupplierUser")
    public Result querySupplierEmployeeAll(@RequestBody HandleSupplierFindAllByName handleSupplierFindAllByName){
        return supplierClient.querySupplierEmployeeAll(handleSupplierFindAllByName);
    }




}
