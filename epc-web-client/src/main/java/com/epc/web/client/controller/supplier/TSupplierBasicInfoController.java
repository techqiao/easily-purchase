package com.epc.web.client.controller.supplier;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.operator.handle.ClientHandleOperatorRole;
import com.epc.web.client.controller.operator.handle.ClientHandleOperatorState;
import com.epc.web.client.controller.supplier.handle.*;
import com.epc.web.client.controller.supplier.query.ClientHandleSupplierCellphone;
import com.epc.web.client.controller.supplier.query.ClientHandleSupplierId;
import com.epc.web.client.controller.supplier.query.ClientHandleSupplierIdAndName;
import com.epc.web.client.controller.supplier.query.ClientSupplierProject;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.operator.handle.HandleOperatorRole;
import com.epc.web.facade.operator.handle.HandleOperatorState;
import com.epc.web.facade.supplier.handle.*;
import com.epc.web.facade.supplier.query.HandleSupplierCellphone;
import com.epc.web.facade.supplier.query.HandleSupplierIdAndName;
import com.epc.web.facade.supplier.query.QuerywithPageHandle;
import com.epc.web.facade.supplier.vo.SupplierBasicInfoVO;
import com.epc.web.facade.supplier.vo.SupplierCategoryVo;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(value = "供应商服务",description = "供应商服务")
@RestController
@RequestMapping(value = "/supplier",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TSupplierBasicInfoController extends BaseController {

    @Autowired
    private SupplierClient supplierClient;



    /**0
     * 注册供应商
     *  自己找到平台网站注册供应商
     */
    @ApiOperation(value = "0:自己找到平台网站注册供应商",notes = "donghuan")
    @PostMapping(value = "public/registerSupplier")
    public Result<Boolean> registerSupplier(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail){
        HandleSupplierDetail handleSupplierDetail=new HandleSupplierDetail();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return supplierClient.registerSupplier(handleSupplierDetail);
    }


    /**2
     *  完善供应商信息
     */
    @ApiOperation(value = "2:完善供应商信息",notes = "donghuan")
    @PostMapping(value = "/public/insertCompleteSupplierInfo")
    public Result<Boolean> insertCompleteSupplierInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
        return supplierClient.insertCompleteSupplierInfo(roleDetailInfo);
    }

    //--------------------------平台审核通过之后----------------------------------

    /**3
     * 供应商增加一个员工(有可能增加的是一个管理员)
     */
    @ApiOperation(value = "3:供应商增加一个员工(有可能增加的是一个管理员)",notes = "donghuan")
    @PostMapping(value = "/createSupplierEmployee")
    public Result<Boolean> createSupplierEmployee(@RequestBody ClientHandlerSupplierAddEmployee clientHandlerSupplierAddEmployee){
        HandlerSupplierAddEmployee handlerSupplierAddEmployee=new HandlerSupplierAddEmployee();
        BeanUtils.copyProperties(clientHandlerSupplierAddEmployee,handlerSupplierAddEmployee);
        handlerSupplierAddEmployee.setPassword("epc1688");
        Long bossId = getLoginUser().getBossId();
        Integer loginRole = getLoginUser().getLoginRole();
        if(bossId==null || loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handlerSupplierAddEmployee.setSupplierId(bossId);
        handlerSupplierAddEmployee.setLoginRole(loginRole);
        return supplierClient.createSupplierEmployee(handlerSupplierAddEmployee);
    }

    /**4
     * 根据员工的id来查询基本信息
     */
    @ApiOperation(value = "4:根据员工的id来查询基本信息",notes = "donghuan")
    @PostMapping(value = "/findSupplierBasicById")
    public Result<SupplierBasicInfoVO> findSupplierBasicById(@RequestBody ClientHandleSupplierId clientHandleSupplierId){
        HandleFindSupplierBasicById handleFindSupplierBasicById=new HandleFindSupplierBasicById();
        BeanUtils.copyProperties(clientHandleSupplierId,handleFindSupplierBasicById);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleFindSupplierBasicById.setLoginRole(loginRole);
        return supplierClient.findSupplierBasicById(handleFindSupplierBasicById);
    }

    /**5
     *  供应商通过id修改员工
     *     通过id查询这个用户信息，得到用户提交的数据，并且设置到对应的实体类中
     */
    @ApiOperation(value = "5:供应商通过id修改员工",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeById")
    public Result<Boolean> updateSupplierEmployeeById(@RequestBody ClientHandlerUpdateSupplierEmployeeById clientHandlerUpdateSupplierEmployeeById){
        HandlerUpdateSupplierEmployeeById handlerUpdateSupplierEmployeeById=new HandlerUpdateSupplierEmployeeById();
        BeanUtils.copyProperties(clientHandlerUpdateSupplierEmployeeById,handlerUpdateSupplierEmployeeById);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handlerUpdateSupplierEmployeeById.setLoginRole(loginRole);
        return supplierClient.updateSupplierEmployeeById(handlerUpdateSupplierEmployeeById);
    }

    /**6 查看个人信息
     * 员工通过id来查询 个人信息   (分两种情况，是老板，不是老板。不需要前端 传任何数据，直接用登陆个人信息里面的id与role)
     */
    @ApiOperation(value = "员工id来查询（公司法人supplier_id）公司详情（包括附件）--6",notes = "donghuan")
    @PostMapping(value = "/findSupplierDetailByEmployee")
    public Result<RoleDetailInfo> findSupplierDetailByEmployee() {
        HandleFindSupplierBasicById handleFindSupplierBasicById=new HandleFindSupplierBasicById();
        Long userId = getLoginUser().getUserId();
        Integer loginRole = getLoginUser().getLoginRole();
        if(userId==null || loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleFindSupplierBasicById.setId(userId);
        handleFindSupplierBasicById.setLoginRole(loginRole);
        return supplierClient.findSupplierDetailByEmployee(handleFindSupplierBasicById);
    }

    /**6.5  查看公司详情
     * 管理员或者员工 通过登陆信息里面的 bossId 来查看  公司详情（包括附件）
     */
    @ApiOperation(value = "管理员或者员工 通过登陆信息里面的 bossId 来查看  公司详情（包括附件）--6.5",notes = "donghuan")
    @PostMapping(value = "/findSupplierByBossId")
    public Result<RoleDetailInfo> findSupplierByBossId(){
        HandleFindSupplierBasicById handleFindSupplierBasicById=new HandleFindSupplierBasicById();
        Integer loginRole = getLoginUser().getLoginRole();
        Long bossId= getLoginUser().getBossId();
        if(loginRole==null || bossId==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleFindSupplierBasicById.setId(bossId);
        handleFindSupplierBasicById.setLoginRole(loginRole);
        return supplierClient.findSupplierByBossId(handleFindSupplierBasicById);
    }

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @ApiOperation(value = "7:根据电话来查找一条记录,返回一个真假值",notes = "donghuan")
    @PostMapping(value = "/findSupplierRecordByCellphone")
    public Result<Boolean> findSupplierRecordByCellphone(@RequestBody ClientHandleSupplierCellphone clientHandleSupplierCellphone){
        HandleSupplierCellphone handleSupplierCellphone=new HandleSupplierCellphone();
        BeanUtils.copyProperties(clientHandleSupplierCellphone,handleSupplierCellphone);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleSupplierCellphone.setLoginRole(loginRole);
        return supplierClient.findSupplierRecordByCellphone(handleSupplierCellphone);
    }

    /**8
     * 根据电话来查找一条记录,返回一个基本信息
     */
    @ApiOperation(value = "8:根据电话来查找一条记录,返回一个基本信息",notes = "donghuan")
    @PostMapping(value = "/findSupplierByCellphone")
    public Result<SupplierBasicInfoVO> findSupplierByCellphone(@RequestBody ClientHandleSupplierCellphone clientHandleSupplierCellphone){
        HandleSupplierCellphone handleSupplierCellphone=new HandleSupplierCellphone();
        BeanUtils.copyProperties(clientHandleSupplierCellphone,handleSupplierCellphone);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleSupplierCellphone.setLoginRole(loginRole);
        return supplierClient.findSupplierByCellphone(handleSupplierCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */
    @ApiOperation(value = "9:通过员工id只修改员工是否禁用",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeByisDeleted")
    public Result<Boolean> updateSupplierEmployeeByisDeleted(@RequestBody ClientHandleSupplierIdAndIsForbidden clientHandleSupplierIdAndIsForbidden){
        HandleSupplierIdAndIsForbidden handleSupplierIdAndIsForbidden=new HandleSupplierIdAndIsForbidden();
        BeanUtils.copyProperties(clientHandleSupplierIdAndIsForbidden,handleSupplierIdAndIsForbidden);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleSupplierIdAndIsForbidden.setLoginRole(loginRole);
        return supplierClient.updateSupplierEmployeeByisDeleted(handleSupplierIdAndIsForbidden);
    }

    /**10
     * 根据员工id来删除一个员工,只是将 is_deleted 改为1，
     */
    @ApiOperation(value = "10:根据员工id来删除一个员工,只是将 is_deleted 改为1，",notes = "donghuan")
    @PostMapping(value = "/clientHandleSupplierIdAndIsForbidden")
    public Result<Boolean> clientHandleSupplierIdAndIsForbidden(@RequestBody ClientHandleSupplieIsDeleted clientHandleSupplieIsDeleted){
        HandleSupplieIsDeleted handleSupplieIsDeleted=new HandleSupplieIsDeleted();
        BeanUtils.copyProperties(clientHandleSupplieIsDeleted,handleSupplieIsDeleted);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleSupplieIsDeleted.setLoginRole(loginRole);
        return supplierClient.deleteSupplierEmployeeById(handleSupplieIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工
     * @author donghuan
     */
    @ApiOperation(value = "11:根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeRoleById")
    public Result<Boolean> updateSupplierEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
        Integer loginRole = getLoginUser().getLoginRole();
        if(loginRole==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleOperatorRole.setLoginRole(loginRole);
        return supplierClient.updateSupplierEmployeeRoleById(handleOperatorRole);
    }

    /**12
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @ApiOperation(value = "12:通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败",notes = "donghuan")
    @PostMapping(value = "/updateSupplierEmployeeStateById")
    public Result<Boolean> updateSupplierEmployeeStateById(@RequestBody ClientHandleOperatorState clientHandleOperatorState){
        HandleOperatorState handleOperatorState=new HandleOperatorState();
        BeanUtils.copyProperties(clientHandleOperatorState,handleOperatorState);
        return supplierClient.updateSupplierEmployeeStateById(handleOperatorState);
    }

    /**13
     *  忘记密码
     */
    @ApiOperation(value = "13:忘记密码",notes = "donghuan")
    @PostMapping(value = "public/forgetPasswordSupplier")
    public Result<Boolean> forgetPasswordSupplier(@RequestBody ClientHandleSupplierForgetPassword clientHandleSupplierForgetPassword) {
        HandleSupplierForgetPassword handleSupplierForgetPassword=new HandleSupplierForgetPassword();
        BeanUtils.copyProperties(clientHandleSupplierForgetPassword,handleSupplierForgetPassword);
        return supplierClient.forgetPasswordSupplier(handleSupplierForgetPassword);
    }


    /**14
     * 根据员工的名字,角色，是否禁用 来匹配出符合条件的员工返回一个list：
     */
    @ApiOperation(value = "14:根据员工的名字,角色，是否禁用 来匹配出符合条件的员工返回一个list",notes = "donghuan")
    @PostMapping(value = "/querySupplierEmployeeAll")
    public Result<Map<String,Object>> querySupplierEmployeeAll(@RequestBody ClientHandleSupplierIdAndName clientHandleSupplierIdAndName){
        HandleSupplierIdAndName handleSupplierIdAndName=new HandleSupplierIdAndName();
        BeanUtils.copyProperties(clientHandleSupplierIdAndName,handleSupplierIdAndName);
        Integer loginRole = getLoginUser().getLoginRole();
        Long bossId = getLoginUser().getBossId();
        if(loginRole==null || bossId==null){
            return Result.error("从redis中获取当前登陆用户信息 异常");
        }
        handleSupplierIdAndName.setLoginRole(loginRole);
        handleSupplierIdAndName.setBossId(bossId);
        return supplierClient.querySupplierEmployeeAll(handleSupplierIdAndName);
    }


    @ApiOperation(value = "15:根据当前登录供应商获取对应项目列表")
    @PostMapping("/querySupplierProject")
    public Result<Map<String, Object>> querySupplierProject(@RequestBody ClientSupplierProject clientSupplierProject){
        QuerywithPageHandle querywithPageHandle = new QuerywithPageHandle();
        BeanUtils.copyProperties(clientSupplierProject,querywithPageHandle);
        querywithPageHandle.setBossId(getLoginUser().getBossId());
        querywithPageHandle.setUserId(getLoginUser().getUserId());
         return supplierClient.querySupplierProject(querywithPageHandle);
    }

    @ApiOperation(value = "16:获得供货商类别列表")
    @RequestMapping("/querySupplierCategory")
    public Result<List<SupplierCategoryVo>> querySupplierCategory(){
        return supplierClient.querySupplierCategory();
    }


    /*@ApiOperation(value = "17:供应商法人指定项目负责人")
    @PostMapping("/assignProjectPrincipal")
    public Result assignProjectPrincipal(@RequestBody ClientProjectPrincipal ClientProjectPrincipal){
        BeanUtils.copyProperties(clientSupplierProject,querywithPageHandle);
        querywithPageHandle.setBossId(getLoginUser().getBossId());
        querywithPageHandle.setUserId(getLoginUser().getUserId());
        return supplierClient.querySupplierProject(querywithPageHandle);
    }*/
}
