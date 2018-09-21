package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.controller.supplier.handle.*;
import com.epc.web.client.controller.supplier.query.ClientHandleFindSupplierByCellphone;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierFindAllByName;
import com.epc.web.facade.supplier.query.HandleSupplierNameAndCellphone;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "供应商服务")
@RestController
@RequestMapping(value = "/supplier",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController {

    @Autowired
    private SupplierClient supplierClient;

    @ApiOperation(value="供应商注册",notes = "供应商注册")
    @PostMapping(value = "/registerSupplier")
    public Result<Boolean> registerSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail) {
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.registerSupplier(handleSupplierDetail);
    }

    @ApiOperation(value = "根据电话来查找一条记录,返回一个记录",notes = "根据电话来查找一条记录,返回一个记录")
    @PostMapping(value = "/findSupplierByCellphone")
    public  Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody ClientHandleFindSupplierByCellphone clientHandleFindSupplierByCellphone){
        HandleFindSupplierByCellphone handleFindSupplierByCellphone=new HandleFindSupplierByCellphone();
        BeanUtils.copyProperties(clientHandleFindSupplierByCellphone,handleFindSupplierByCellphone);
        return supplierClient.findSupplierByCellphone(handleFindSupplierByCellphone);
    }


    @ApiOperation(value="根据名字电话来得到这个人的信息",notes = "根据名字电话来得到这个人的信息")
    @PostMapping(value = "/findByNameSupplier")
    public Result<SupplierBasicInfoVO> findByName(@RequestBody ClientHandleSupplierNameAndCellphone clientHandleSupplierNameAndCellphone) {
        HandleSupplierNameAndCellphone handleSupplierNameAndCellphone=new HandleSupplierNameAndCellphone();
        BeanUtils.copyProperties(clientHandleSupplierNameAndCellphone,handleSupplierNameAndCellphone);
        return supplierClient.findByName(handleSupplierNameAndCellphone);
    }


    @ApiOperation(value="忘记密码",notes = "忘记密码")
    @PostMapping(value = "/forgetPassword")
    public Result<Boolean> forgetPassword(@RequestBody ClientHandleSupplierForgetPassword clientHandleSupplierForgetPassword) {
        HandleSupplierForgetPassword handleSupplierForgetPassword=new HandleSupplierForgetPassword();
        BeanUtils.copyProperties(clientHandleSupplierForgetPassword,handleSupplierForgetPassword);
        return supplierClient.forgetPassword(handleSupplierForgetPassword);
    }

    /*===========================================================*/


    @ApiOperation(value = "供应商添加员工",notes = "供应商添加自己的员工")
    @PostMapping(value="/createSupplierEmployee")
    public Result<Boolean> createSupplierEmployee(@RequestBody ClientHandlerSupplierAddEmployee clientHandlerSupplierAddEmployee){
        HandlerSupplierAddEmployee handlerSupplierAddEmployee=new HandlerSupplierAddEmployee();
        BeanUtils.copyProperties(clientHandlerSupplierAddEmployee,handlerSupplierAddEmployee);
        return supplierClient.createSupplierEmployee(handlerSupplierAddEmployee);
    }


    @ApiOperation(value = "供应商修改员工",notes = "供应商通过员工id来修改名字和手机号及状态是否可用")
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
