package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.controller.supplier.handle.*;
import com.epc.web.client.controller.supplier.query.ClientHandleFindSupplierByInfo;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleFindSupplierByInfo;
import com.epc.web.facade.supplier.vo.SupplierAttachmentAndDetailVO;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "根据员工的id来查询基本信息",notes = "根据员工的id来查询基本信息")
    @PostMapping(value = "/findSupplierBasicById")
    public Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo) {
        HandleFindSupplierByInfo handleFindSupplierByInfo=new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo,handleFindSupplierByInfo);
        return supplierClient.findSupplierBasicById(handleFindSupplierByInfo);
    }

    @ApiOperation(value = "根据员工的id来删除员工",notes = "根据员工的id来删除员工")
    @PostMapping(value = "/deleteSupplierEmployeeById")
    public Result<Boolean> deleteSupplierEmployeeById(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo) {
        HandleFindSupplierByInfo handleFindSupplierByInfo=new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo,handleFindSupplierByInfo);
        return supplierClient.deleteSupplierEmployeeById(handleFindSupplierByInfo);
    }

    @ApiOperation(value = "员工查看 公司详情",notes = "员工查看 公司详情")
    @PostMapping(value = "/findSupplierDetailByEmployee")
    Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo){
        HandleFindSupplierByInfo  handleFindSupplierByInfo=new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo,handleFindSupplierByInfo);
        return supplierClient.findSupplierDetailByEmployee(handleFindSupplierByInfo);
    }



    @ApiOperation(value = "根据电话来查找一条记录,返回一个记录",notes = "根据电话来查找一条记录,返回一个记录")
    @PostMapping(value = "/findSupplierByCellphone")
    public  Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo){
        HandleFindSupplierByInfo handleFindSupplierByInfo =new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo, handleFindSupplierByInfo);
        return supplierClient.findSupplierByCellphone(handleFindSupplierByInfo);
    }


    @ApiOperation(value="根据名字电话来得到这个人的信息",notes = "根据名字电话来得到这个人的信息")
    @PostMapping(value = "/findByNameSupplier")
    public Result<SupplierBasicInfoVO> findByName(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo) {
        HandleFindSupplierByInfo handleFindSupplierByInfo =new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo,handleFindSupplierByInfo);
        return supplierClient.findByName(handleFindSupplierByInfo);
    }


    @ApiOperation(value="忘记密码",notes = "忘记密码")
    @PostMapping(value = "/forgetPasswordSupplier")
    public Result<Boolean> forgetPassword(@RequestBody ClientHandleSupplierForgetPassword clientHandleSupplierForgetPassword) {
        HandleSupplierForgetPassword handleSupplierForgetPassword=new HandleSupplierForgetPassword();
        BeanUtils.copyProperties(clientHandleSupplierForgetPassword,handleSupplierForgetPassword);
        return supplierClient.forgetPassword(handleSupplierForgetPassword);
    }



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
    @PostMapping(value="/querySupplierEmployeeAll")
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeAll(@RequestBody ClientHandleSupplierFindAllByName clientHandleSupplierFindAllByName){
        HandleFindSupplierByInfo handleFindSupplierByInfo =new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleSupplierFindAllByName,handleFindSupplierByInfo);
        return supplierClient.querySupplierEmployeeAll(handleFindSupplierByInfo);
    }

    @ApiOperation(value = "完善供应商信息",notes = "完善供应商信息")
    @PostMapping(value = "/completeSupplierInfo")
    Result<Boolean> insertCompleteSupplierInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
        return supplierClient.insertCompleteSupplierInfo(roleDetailInfo);
    }

}
