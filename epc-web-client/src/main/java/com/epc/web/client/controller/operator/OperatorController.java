package com.epc.web.client.controller.operator;

import com.epc.common.Result;
import com.epc.web.client.controller.operator.handle.*;
import com.epc.web.client.controller.operator.query.ClientHandleOperatorCellphone;
import com.epc.web.client.controller.operator.query.ClientHandleOperatorFindAllByName;
import com.epc.web.client.controller.operator.query.ClientHandleOperatorId;
import com.epc.web.client.controller.supplier.handle.ClientRoleDetailInfo;
import com.epc.web.client.remoteApi.operator.OperatorClient;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.query.HandleOperatorCellphone;
import com.epc.web.facade.operator.query.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.query.HandleOperatorId;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.supplier.handle.RoleDetailInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "运营商服务"/*,tags = "运营商服务"*/)
@RestController
@RequestMapping(value = "/operator", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController/* extends BaseController */{

    @Autowired
    private OperatorClient operatorClient;

    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    @ApiOperation(value = "0:运营商注册(没有通过任何人拉取的，自己找到平台来注册的)",notes = "donghuan")
    @PostMapping(value = "public/registerOperator")
    public Result<Boolean> registerOperator(@RequestBody ClientHandleOperator clientHandleOperator){
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.registerOperator(handleOperator);
    }


    /**0.5
     * 已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆
     */
    @ApiOperation(value = "0.5:已经被人拉取过的，校验电话与名字是否在数据库中有，并且密码为空的，才让其设置密码进行登陆",notes = "donghuan")
    @PostMapping(value = "public/addPasswordOperatorLogin")
    public Result<Boolean> addPasswordOperatorLogin(@RequestBody ClientHandleOperator clientHandleOperator){
        HandleOperator  handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.addPasswordOperatorLogin(handleOperator);
    }
    /**1
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
    @ApiOperation(value = "1:运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)",notes = "donghuan")
    @PostMapping(value = "public/addPasswordOperator")
    public Result<Boolean> addPasswordOperator(@RequestBody ClientHandleOperator clientHandleOperator){
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.addPasswordOperator(handleOperator);
    }

    /**2
     * 完善运营商信息
     */
    @ApiOperation(value = "2:完善运营商信息)",notes = "donghuan")
    @PostMapping(value = "/insertCompleteOperatorInfo")
    public Result<Boolean> insertCompleteOperatorInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
        return operatorClient.insertCompleteOperatorInfo(roleDetailInfo);
    }


    //--------------------------平台审核通过之后----------------------------------


    /**3
     * 运营商增加一个员工
     */
    @ApiOperation(value = "3:运营商增加一个员工",notes = "donghuan")
    @PostMapping(value = "/createOperatorEmployee")
    public Result<Boolean> createOperatorEmployee(@RequestBody ClientHandleOperatorAddEmployee clientHandleOperatorAddEmployee){
        HandleOperatorAddEmployee handleOperatorAddEmployee=new HandleOperatorAddEmployee();
//        ClientLoginUser loginUser = getLoginUser();
//        handleOperatorAddEmployee.setId(Long.valueOf(loginUser.getBossId()));
        BeanUtils.copyProperties(clientHandleOperatorAddEmployee,handleOperatorAddEmployee);
        return operatorClient.createOperatorEmployee(handleOperatorAddEmployee);
    }

    /**4
     * 依据id查询已经登陆的个人信息
     */
    @ApiOperation(value = "4:依据id查询已经登陆的个人信息",notes = "donghuan")
    @PostMapping(value = "/findByNameOperator")
    public Result<OperatorBasicInfoVO> findByName(@RequestBody ClientHandleOperatorId clientHandleOperatorId){
        HandleOperatorId handleOperatorId=new HandleOperatorId();
        BeanUtils.copyProperties(clientHandleOperatorId,handleOperatorId);
        return operatorClient.findByName(handleOperatorId);
    }

    /**5
     * 通过员工id来修改员工信息
     */
    @ApiOperation(value = "5:通过员工id来修改员工信息",notes = "donghuan")
    @PostMapping(value = "/updateOperatorEmployeeById")
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody ClientHandleOperatorUpdateEmployeeById clientHandleOperatorUpdateEmployeeById){
        HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById=new HandleOperatorUpdateEmployeeById();
        BeanUtils.copyProperties(clientHandleOperatorUpdateEmployeeById,handleOperatorUpdateEmployeeById);
        return operatorClient.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**6
     * 员工id来查询（公司法人supplier_id） 公司详情（包括附件）
     */

    /**7
     * 根据电话来查找一条记录,返回一个真假值
     */
    @ApiOperation(value = "7:根据电话来查找一条记录,返回一个真假值",notes = "donghuan")
    @PostMapping(value = "/findOperatorRecordByCellphone")
    public Result<Boolean> findOperatorRecordByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
        return operatorClient.findOperatorRecordByCellphone(handleOperatorCellphone);
    }

    /**8
     * 依据电话来删除一个员工,只是改变is_deleted 为1
     */
    @ApiOperation(value = "8:依据电话来删除一个员工,只是改变is_deleted 为1",notes = "donghuan")
    @PostMapping(value = "/deleteOperatorEmployeeByCellphone")
    public Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
        return operatorClient.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
    }

    /**9
     * 通过员工id 只 修改员工 是否禁用
     */

    /**10
     * 依据id来删除一个员工,只是改变is_deleted 为1
     */
    @ApiOperation(value = "10:依据id来删除一个员工,只是改变is_deleted 为1",notes = "donghuan")
    @PostMapping(value = "/deleteOperatorEmployeeById")
    public Result<Boolean> deleteOperatorEmployeeById(@RequestBody ClientHandleOperatorIdAndIsDeleted clientHandleOperatorIdAndIsDeleted){
        HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted=new HandleOperatorIdAndIsDeleted();
        BeanUtils.copyProperties(clientHandleOperatorIdAndIsDeleted,handleOperatorIdAndIsDeleted);
        return operatorClient.deleteOperatorEmployeeById(handleOperatorIdAndIsDeleted);
    }

    /**11
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     */
    @ApiOperation(value = "11:根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工",notes = "donghuan")
    @PostMapping(value = "/updateOperatorEmployeeRoleById")
    public Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
        return operatorClient.updateOperatorEmployeeRoleById(handleOperatorRole);
    }

    /**12
     *  通过id来改变员工是否禁用
     */
    @ApiOperation(value = "12:通过id来改变员工是否禁用",notes = "donghuan")
    @PostMapping(value = "/updateOperatorEmployeeByisDeleted")
    public Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody ClientHandleOperatorIdAndIsForbidden clientHandleOperatorIdAndIsForbidden){
        HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden=new HandleOperatorIdAndIsForbidden();
        BeanUtils.copyProperties(clientHandleOperatorIdAndIsForbidden,handleOperatorIdAndIsForbidden);
        return operatorClient.updateOperatorEmployeeByisDeleted(handleOperatorIdAndIsForbidden);
    }

    /**13
     * 运营商忘记密码
     */
    @ApiOperation(value = "13:运营商忘记密码",notes = "donghuan")
    @PostMapping(value = "public/forgetPasswordOperator")
    public Result<Boolean> forgetPassword(@RequestBody ClientHandleOperatorForgetPassword clientHandleOperatorForgetPassword){
        HandleOperatorForgetPassword handleOperatorForgetPassword=new HandleOperatorForgetPassword();
        BeanUtils.copyProperties(clientHandleOperatorForgetPassword,handleOperatorForgetPassword);
        return operatorClient.forgetPasswordOperator(handleOperatorForgetPassword);
    }

    /**14
     * 根据员工的名字,角色，是否禁用,来匹配出符合条件的员工返回一个list：
     */
    @ApiOperation(value = "14:根据员工的名字,角色，是否禁用,来匹配出符合条件的员工返回一个list",notes = "donghuan")
    @PostMapping(value = "/queryOperatorEmployeeAll")
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(@RequestBody ClientHandleOperatorFindAllByName clientHandleOperatorFindAllByName){
        HandleOperatorFindAllByName handleOperatorFindAllByName=new HandleOperatorFindAllByName();
        BeanUtils.copyProperties(clientHandleOperatorFindAllByName,handleOperatorFindAllByName);
        return operatorClient.queryOperatorEmployeeAll(handleOperatorFindAllByName);
    }

    /**15
     *  运营商新增采购人（包括完善信息）
     */
    @ApiOperation(value = "15:运营商新增采购人（包括完善信息）",notes = "donghuan")
    @PostMapping(value = "/createPurchaseByOperator")
    public Result<Boolean> createPurchaseByOperator(@RequestBody ClientHandleCreatePurchaserByOperator clientHandleCreatePurchaserByOperator){
        HandleCreatePurchaserByOperator handleCreatePurchaserByOperator=new HandleCreatePurchaserByOperator();
        BeanUtils.copyProperties(clientHandleCreatePurchaserByOperator,handleCreatePurchaserByOperator);
        return operatorClient.createPurchaseByOperator(handleCreatePurchaserByOperator);
    }

    /**16
     *  运营商新增采购人（不包括完善信息，只填写姓名，电话）
     */
    @ApiOperation(value = "16:运营商新增采购人（不包括完善信息，只填写姓名，电话）",notes = "donghuan")
    @PostMapping(value = "/createPurchaseByOperatorSimple")
    public Result<Boolean> createPurchaseByOperatorSimple(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
        return operatorClient.createPurchaseByOperatorSimple(handleOperatorCreateSupplier);
    }


    /**17
     *  运营商新增供应商  (不包括完善信息,只填 姓名、电话)
     */
    @ApiOperation(value = "17:运营商新增供应商  (不包括完善信息,只填 姓名、电话)",notes = "donghuan")
    @PostMapping(value = "/operatorCreateSupplierSimple")
    public Result<Boolean> operatorCreateSupplierSimple(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
        return operatorClient.operatorCreateSupplierSimple(handleOperatorCreateSupplier);
    }


    /**18
     *  运营商新增供应商（包括完善信息）
     */
    @ApiOperation(value = "18:运营商新增供应商（包括完善信息）",notes = "donghuan")
    @PostMapping(value = "/operatorCreateSupplier")
    public Result<Boolean> operatorCreateSupplier(@RequestBody ClientHandleCreatePurchaserByOperator clientHandleCreatePurchaserByOperator){
        HandleCreatePurchaserByOperator handleCreatePurchaserByOperator=new HandleCreatePurchaserByOperator();
        BeanUtils.copyProperties(clientHandleCreatePurchaserByOperator,handleCreatePurchaserByOperator);
        return operatorClient.operatorCreateSupplier(handleCreatePurchaserByOperator);
    }






}
