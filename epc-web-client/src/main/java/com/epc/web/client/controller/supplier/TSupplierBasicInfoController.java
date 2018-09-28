package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.controller.operator.handle.ClientHandleOperatorRole;
import com.epc.web.client.controller.operator.handle.ClientHandleOperatorState;
import com.epc.web.client.controller.supplier.handle.*;
import com.epc.web.client.controller.supplier.query.ClientHandleFindSupplierByInfo;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
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


@Api(value = "供应商服务",tags = "供应商服务")
@RestController
@RequestMapping(value = "/supplier",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController {

    @Autowired
    private SupplierClient supplierClient;

    @ApiOperation(value="自己找到平台网站注册供应商",notes = "自己找到平台网站注册供应商")
    @PostMapping(value = "/registerSupplier")
    public Result<Boolean> registerSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail) {
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.registerSupplier(handleSupplierDetail);
    }

    @ApiOperation(value = "由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号",notes = "由其他角色拉入平台网站 ，直接设置密码 ，登陆供应商账号")
    @PostMapping(value = "/addPasswordSupplier")
    public Result<Boolean> addPasswordSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail){
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.addPasswordSupplier(handleSupplierDetail);
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

//    @ApiOperation(value = "依据电话来删除一个员工",notes = "依据电话来删除一个员工")
//    @PostMapping(value = "/deleteOperatorEmployeeByCellphone")
//    public Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
//        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
//        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
//        return supplierClient.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
//    }

    @ApiOperation(value = "通过员工id 只 修改员工的状态",notes = "通过员工id 只 修改员工的状态")
    @PostMapping(value = "/updateSupplierEmployeeByisDeleted")
    public Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody ClientHandleSupplierEmployeeByisDeleted clientHandleSupplierEmployeeByisDeleted){
        HandleSupplierEmployeeByisDeleted handleSupplierEmployeeByisDeleted=new HandleSupplierEmployeeByisDeleted();
        BeanUtils.copyProperties(clientHandleSupplierEmployeeByisDeleted,handleSupplierEmployeeByisDeleted);
        return supplierClient.updateSupplierEmployeeByisDeleted(handleSupplierEmployeeByisDeleted);
    }

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @ApiOperation(value = "根据用户id来修改他的role",notes = "根据用户id来修改他的role")
    @PostMapping(value = "/updateSupplierEmployeeRoleById")
    public Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
        return supplierClient.updateSupplierEmployeeRoleById(handleOperatorRole);
    }

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @ApiOperation(value = " 通过id来修改对应的state ",notes = " 通过id来修改对应的state ")
    @PostMapping(value = "/updateSupplierEmployeeStateById")
    public Result<Boolean> updateSupplierEmployeeStateById(@RequestBody ClientHandleOperatorState clientHandleOperatorState){
        HandleOperatorState handleOperatorState=new HandleOperatorState();
        BeanUtils.copyProperties(clientHandleOperatorState,handleOperatorState);
        return supplierClient.updateSupplierEmployeeStateById(handleOperatorState);
    }

    @ApiOperation(value = "员工id来查询（公司法人supplier_id） 公司详情（包括附件）",notes = "员工id来查询（公司法人supplier_id） 公司详情（包括附件）")
    @PostMapping(value = "/findSupplierDetailByEmployee")
    public Result<SupplierAttachmentAndDetailVO> findSupplierDetailByEmployee(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo){
        HandleFindSupplierByInfo  handleFindSupplierByInfo=new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo,handleFindSupplierByInfo);
        return supplierClient.findSupplierDetailByEmployee(handleFindSupplierByInfo);
    }

    @ApiOperation(value = "据电话来查找一条记录,返回一个真假值",notes = "据电话来查找一条记录,返回一个真假值")
    @PostMapping(value = "/findSupplierRecordByCellphone")
    public Result<Boolean> findSupplierRecordByCellphone(@RequestBody ClientHandleSupplierRecordByCellphone clientHandleSupplierByCellphone){
        HandleSupplierRecordByCellphone handleSupplierRecordByCellphone=new HandleSupplierRecordByCellphone();
        BeanUtils.copyProperties(clientHandleSupplierByCellphone,handleSupplierRecordByCellphone);
        return supplierClient.findSupplierRecordByCellphone(handleSupplierRecordByCellphone);
    }


    @ApiOperation(value = "根据电话来查找一条记录,返回一个记录",notes = "根据电话来查找一条记录,返回一个记录")
    @PostMapping(value = "/findSupplierByCellphone")
    public  Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo){
        HandleFindSupplierByInfo handleFindSupplierByInfo =new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo, handleFindSupplierByInfo);
        return supplierClient.findSupplierByCellphone(handleFindSupplierByInfo);
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

    @ApiOperation(value = "由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)",notes = "由员工状态来查询出员工的列表:(你给我你的id, 我找出这个角色当中符合这个状态的所有员工)")
    @PostMapping(value = "/querySupplierEmployeeByisDeleted")
    public Result<List<SupplierBasicInfoVO>> querySupplierEmployeeByisDeleted(@RequestBody ClientHandleFindSupplierByInfo clientHandleFindSupplierByInfo){
        HandleFindSupplierByInfo handleFindSupplierByInfo=new HandleFindSupplierByInfo();
        BeanUtils.copyProperties(clientHandleFindSupplierByInfo,handleFindSupplierByInfo);
        return supplierClient.querySupplierEmployeeByisDeleted(handleFindSupplierByInfo);
    }



    @ApiOperation(value = "完善供应商信息",notes = "完善供应商信息")
    @PostMapping(value = "/insertCompleteSupplierInfo")
    Result<Boolean> insertCompleteSupplierInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
        return supplierClient.insertCompleteSupplierInfo(roleDetailInfo);
    }



}
