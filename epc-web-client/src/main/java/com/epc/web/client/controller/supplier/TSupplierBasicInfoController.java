package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.controller.supplier.handle.*;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierDetailInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "供应商服务",tags = {"供应商项目服务"})
@RestController
@RequestMapping(value = "/supplier",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController {

    @Autowired
    private SupplierClient supplierClient;

    //供应商注册
    public Result registerSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail) {
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.registerSupplier(handleSupplierDetail);
    }

    //登陆
    public Result<SupplierBasicInfoVO> login(@RequestParam String cellphone, String password) {
        return supplierClient.login(cellphone,password);
    }


    @ApiModelProperty(value="根据名字或者电话来得到这个人的信息")
    @PostMapping(value = "/findByName")
    public Result<SupplierDetailInfoVO> findByName(@RequestParam String name, String cellphone) {
        return supplierClient.findByName(name,cellphone);
    }


    @ApiModelProperty(value="忘记密码")
    @PostMapping(value = "/forgetPassword")
    public Result<Boolean> forgetPassword(@RequestBody ClientHandleSupplierForgetPassword clientHandleSupplierForgetPassword) {
        HandleSupplierForgetPassword handleSupplierForgetPassword=new HandleSupplierForgetPassword();
        BeanUtils.copyProperties(clientHandleSupplierForgetPassword,handleSupplierForgetPassword);
        return supplierClient.forgetPassword(handleSupplierForgetPassword);
    }

    /*===========================================================*/


    @ApiOperation(value = "供应商添加员工")
    @PostMapping(value="/createSupplierEmployee")
    public Result<Boolean> createSupplierEmployee(@RequestBody ClientHandlerSupplierAddEmployee clientHandlerSupplierAddEmployee){
        HandlerSupplierAddEmployee handlerSupplierAddEmployee=new HandlerSupplierAddEmployee();
        BeanUtils.copyProperties(clientHandlerSupplierAddEmployee,handlerSupplierAddEmployee);
        return supplierClient.createSupplierEmployee(handlerSupplierAddEmployee);
    }


    //供应商通过员工id来修改名字和手机号及状态是否可用
    @ApiOperation(value = "供应商修改员工")
    @PostMapping(value="/updateSupplierEmployeeById")
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody ClientHandlerUpdateSupplierEmployeeById clientHandlerUpdateSupplierEmployeeById){
        HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById=new HandlerUpdateSupplierEmployeeById();
        BeanUtils.copyProperties(clientHandlerUpdateSupplierEmployeeById,handlerUpdateSupplierEmployeeById);
        return supplierClient.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }


    @ApiOperation(value = "根据员工姓名模糊查询",notes = "根据员工姓名模糊查询")
    @PostMapping(value="/createSupplierUser")
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody ClientHandleSupplierFindAllByName clientHandleSupplierFindAllByName){
        HandleSupplierFindAllByName handleSupplierFindAllByName=new HandleSupplierFindAllByName();
        BeanUtils.copyProperties(clientHandleSupplierFindAllByName,handleSupplierFindAllByName);
        return supplierClient.querySupplierEmployeeAll(handleSupplierFindAllByName);
    }






}
