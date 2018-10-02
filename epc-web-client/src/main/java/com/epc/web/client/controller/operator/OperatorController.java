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
public class OperatorController {

    @Autowired
    private OperatorClient operatorClient;

//    /**
//     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
//     * @author donghuan
//     */
//    @ApiOperation(value = "运营商注册(没有通过任何人拉取的，自己找到平台来注册的)",notes = "运营商注册(没有通过任何人拉取的，自己找到平台来注册的)")
//    @PostMapping(value = "/registerOperator")
//    public Result<Boolean> registerOperator(@RequestBody ClientHandleOperator clientHandleOperator) {
//        HandleOperator handleOperator=new HandleOperator();
//        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
//        return operatorClient.registerOperator(handleOperator);
//    }
//
//    /**
//     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
//     * @author donghuan
//     */
//    @ApiOperation(value = "运营商注册（有人拉的，手机与名字都有,只需要设置密码就可以完成登陆)",notes = "运营商注册（有人拉的，手机与名字都有,只需要设置密码就可以完成登陆)")
//    @PostMapping(value = "/addPasswordOperator")
//    public Result<Boolean> addPasswordOperator(@RequestBody ClientHandleOperator clientHandleOperator){
//        HandleOperator handleOperator=new HandleOperator();
//        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
//        return operatorClient.addPasswordOperator(handleOperator);
//    }
//
//    /**2
//     * 完善运营商信息
//     */
//    @ApiOperation(value = "完善运营商信息",notes = "完善运营商信息")
//    @PostMapping(value = "/insertCompleteOperatorInfo")
//    public Result<Boolean> insertCompleteOperatorInfo(@RequestBody ClientRoleDetailInfo clientRoleDetailInfo){
//        RoleDetailInfo roleDetailInfo=new RoleDetailInfo();
//        BeanUtils.copyProperties(clientRoleDetailInfo,roleDetailInfo);
//        return operatorClient.insertCompleteOperatorInfo(roleDetailInfo);
//    }
//
//    /**
//     *   忘记密码
//     *  @author donghuan
//     */
//    @ApiOperation(value = "忘记密码",notes = "修改密码")
//    @PostMapping(value = "/forgetPasswordOperator")
//    public Result<Boolean> forgetPassword(@RequestBody ClientHandleOperatorForgetPassword clientHandleOperatorForgetPassword) {
//        HandleOperatorForgetPassword handleOperatorForgetPassword=new HandleOperatorForgetPassword();
//        BeanUtils.copyProperties(clientHandleOperatorForgetPassword,handleOperatorForgetPassword);
//        return operatorClient.forgetPassword(handleOperatorForgetPassword);
//    }
//
//    /**
//     * 依据id查询已经登陆的个人信息
//     * @author donghuan
//     */
//    @ApiOperation(value = "依据id查询已经登陆的个人信息",notes = "依据id查询已经登陆的个人信息")
//    @PostMapping(value = "/findByNameOperator")
//    public Result<OperatorBasicInfoVO> findByName(@RequestBody ClientHandleOperatorId clientHandleOperatorId) {
//        HandleOperatorId handleOperatorId=new HandleOperatorId();
//        BeanUtils.copyProperties(clientHandleOperatorId,handleOperatorId);
//        return operatorClient.findByName(handleOperatorId);
//    }
//
//    /**
//     * 运营商新增自己的员工
//     * @author donghuan
//     */
//    @ApiOperation(value = "运营商新增自己的员工",notes = "运营商新增自己的员工")
//    @PostMapping(value = "/createOperatorEmployee")
//    public Result<Boolean> createOperatorEmployee(@RequestBody ClientHandleOperatorAddEmployee clientHandleOperatorAddEmployee){
//        HandleOperatorAddEmployee handleOperatorAddEmployee=new HandleOperatorAddEmployee();
//        BeanUtils.copyProperties(clientHandleOperatorAddEmployee,handleOperatorAddEmployee);
//        return operatorClient.createOperatorEmployee(handleOperatorAddEmployee);
//    }
//
//    /**
//     *  根据员工的id来更新该员工的个人信息
//     *  @author donghuan
//     */
//    @ApiOperation(value = "根据员工的id来更新该员工的个人信息",notes = "根据员工的id来更新该员工的个人信息")
//    @PostMapping(value = "/updateOperatorEmployeeById")
//    public Result<Boolean> updateOperatorEmployeeById(@RequestBody ClientHandleOperatorUpdateEmployeeById clientHandleOperatorUpdateEmployeeById){
//        HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById=new HandleOperatorUpdateEmployeeById();
//        BeanUtils.copyProperties(clientHandleOperatorUpdateEmployeeById,handleOperatorUpdateEmployeeById);
//        return operatorClient.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
//    }
//
//    /**
//     * 依据id来删除一个员工
//     * @author donghuan
//     */
//    @ApiOperation(value = "依据id来删除一个员工",notes = "依据id来删除一个员工")
//    @PostMapping(value = "/deleteOperatorEmployeeById")
//    public Result<Boolean> deleteOperatorEmployeeById(@RequestBody ClientHandleOperatorIdAndIsDeleted clientHandleOperatorIdAndIsDeleted){
//        HandleOperatorIdAndIsDeleted handleOperatorIdAndIsDeleted=new HandleOperatorIdAndIsDeleted();
//        BeanUtils.copyProperties(clientHandleOperatorIdAndIsDeleted,handleOperatorIdAndIsDeleted);
//        return operatorClient.deleteOperatorEmployeeById(handleOperatorIdAndIsDeleted);
//    }
//
//    /**
//     *  通过id来改变员工的状态,是否禁用
//     * @author donghuan
//     */
//    @ApiOperation(value = "通过id来改变员工的状态,是否禁用",notes = "通过id来改变员工的状态,是否禁用")
//    @PostMapping(value = "/updateOperatorEmployeeByisDeleted")
//    public Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody ClientHandleOperatorIdAndIsForbidden clientHandleOperatorIdAndIsForbidden){
//        HandleOperatorIdAndIsForbidden handleOperatorIdAndIsForbidden=new HandleOperatorIdAndIsForbidden();
//        BeanUtils.copyProperties(clientHandleOperatorIdAndIsForbidden,handleOperatorIdAndIsForbidden);
//        return operatorClient.updateOperatorEmployeeByisDeleted(handleOperatorIdAndIsForbidden);
//    }
//
//    /**
//     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
//     * @author donghuan
//     */
//    @ApiOperation(value = "通过id来修改对应的state",notes = "通过id来修改对应的state")
//    @PostMapping(value = "/updateOperatorEmployeeStateById")
//    public Result<Boolean> updateOperatorEmployeeStateById(@RequestBody ClientHandleOperatorState clientHandleOperatorState){
//        HandleOperatorState handleOperatorState=new HandleOperatorState();
//        BeanUtils.copyProperties(clientHandleOperatorState,handleOperatorState);
//        return operatorClient.updateOperatorEmployeeStateById(handleOperatorState);
//    }
//
//    /**
//     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
//     * @author donghuan
//     */
//    @ApiOperation(value = "根据用户id来修改他的role ",notes = "根据用户id来修改他的role ")
//    @PostMapping(value = "/updateOperatorEmployeeRoleById")
//    public Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
//        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
//        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
//        return operatorClient.updateOperatorEmployeeRoleById(handleOperatorRole);
//    }
//
//    /**
//     * 依据电话来删除一个员工
//     *  @author donghuan
//     */
//    @ApiOperation(value = "依据电话来删除一个员工",notes = "依据电话来删除一个员工")
//    @PostMapping(value = "/deleteOperatorEmployeeByCellphone")
//    Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
//        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
//        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
//        return operatorClient.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
//    }
//
//    /**
//     * 根据电话来查找一条记录,返回一个真假值
//     * @author donghuan
//     */
//    @ApiOperation(value = "根据电话来查找一条记录,返回一个真假值",notes = "根据电话来查找一条记录,返回一个真假值")
//    @PostMapping(value = "/findOperatorRecordByCellphone")
//    Result<Boolean> findOperatorRecordByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
//        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
//        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
//        return operatorClient.findOperatorRecordByCellphone(handleOperatorCellphone);
//    }
//
//
//    /**
//     *  依据供应商输入的员工姓名来模糊匹配
//     *  @author donghuan
//     */
//    @ApiOperation(value = "依据供应商输入的员工姓名来模糊匹配",notes = "依据供应商输入的员工姓名来模糊匹配")
//    @PostMapping(value = "/queryOperatorEmployeeAll")
//    public Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(@RequestBody ClientHandleOperatorFindAllByName clientHandleOperatorFindAllByName){
//        HandleOperatorFindAllByName handleOperatorFindAllByName=new HandleOperatorFindAllByName();
//        BeanUtils.copyProperties(clientHandleOperatorFindAllByName,handleOperatorFindAllByName);
//        return operatorClient.queryOperatorEmployeeAll(handleOperatorFindAllByName);
//    }
//
//
//    /**
//    * @Description:    运营商新增采购人
//    * @Author:         linzhixiang
//    * @CreateDate:     2018/9/13 10:34
//    * @UpdateUser:     donghuan
//    * @UpdateDate:     2018/9/13 10:34
//    * @UpdateRemark:   修改内容
//    * @Version:        1.0
//    */
//
//    @ApiOperation(value = "运营商添加采购人",notes = "运营商添加采购人")
//    @PostMapping(value = "/createPurchaseByOperator")
//    public Result<Boolean> createPurchaseByOperator(@RequestBody ClientHandleCreatePurchaserByOperator clientHandleCreatePurchaserByOperator) {
//        HandleCreatePurchaserByOperator handleCreatePurchaserByOperator=new HandleCreatePurchaserByOperator();
//        BeanUtils.copyProperties(clientHandleCreatePurchaserByOperator,handleCreatePurchaserByOperator);
//        return operatorClient.createPurchaseByOperator(handleCreatePurchaserByOperator);
//    }
//
//    /**16
//     *  运营商新增采购人（不包括完善信息，只填写姓名，电话）
//     */
//    @ApiOperation(value = "运营商简单的添加采购人",notes = "运营商简单的添加采购人")
//    @PostMapping(value = "createPurchaseByOperatorSimple")
//    public Result<Boolean> createPurchaseByOperatorSimple(@RequestBody ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
//        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
//        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
//        return operatorClient.createPurchaseByOperatorSimple(handleOperatorCreateSupplier);
//    }
//
//
//    /**
//     *  运营商新增供应商  (只填 姓名、电话、来源)
//     * @author donghuan
//     */
//    @ApiOperation(value = "运营商新增供应商  (只填 姓名、电话、来源)",notes = "运营商新增供应商  (只填 姓名、电话、来源)")
//    @PostMapping(value = "/operatorCreateSupplier")
//    public Result<Boolean> operatorCreateSupplier(ClientHandleOperatorCreateSupplier clientHandleOperatorCreateSupplier){
//        HandleOperatorCreateSupplier handleOperatorCreateSupplier=new HandleOperatorCreateSupplier();
//        BeanUtils.copyProperties(clientHandleOperatorCreateSupplier,handleOperatorCreateSupplier);
//        return operatorClient.operatorCreateSupplier(handleOperatorCreateSupplier);
//    }


    /**0
     *  运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     */
    @ApiOperation(value = "0:运营商注册(没有通过任何人拉取的，自己找到平台来注册的)",notes = "donghuan")
    @PostMapping(value = "/registerOperator")
    public Result<Boolean> registerOperator(@RequestBody ClientHandleOperator clientHandleOperator){
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.registerOperator(handleOperator);
    }

    /**1
     *  运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)
     *          (有单独的页面登陆，只需要输入姓名，电话就可以进行登陆，进去直接设置密码，然后完善个人信息，然后下次登陆，就查询这个电话下的这条数据的密码状态是否为空，
     *           不为空，就电话，密码登陆；如果为空，就到相应的姓名电话登陆页面登陆。一旦设置完密码就只能用电话与密码进行登陆【其中每个登陆都要验证码，否则不安全】
     *           )
     */
    @ApiOperation(value = "1:运营商注册,(有人拉的，手机与名字都有,只需要输入电话，姓名就可以登陆)",notes = "donghuan")
    @PostMapping(value = "/addPasswordOperator")
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
    @ApiOperation(value = "9:依据电话来删除一个员工,只是改变is_deleted 为1",notes = "donghuan")
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
    @PostMapping(value = "/forgetPasswordSupplier")
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
