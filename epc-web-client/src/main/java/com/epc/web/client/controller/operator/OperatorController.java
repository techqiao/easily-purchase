package com.epc.web.client.controller.operator;

import com.epc.common.Result;
import com.epc.web.client.controller.operator.handle.*;
import com.epc.web.client.remoteApi.operator.OperatorClient;
import com.epc.web.client.remoteApi.supplier.SupplierClient;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.Validate;
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

    /**
     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     * @author donghuan
     */
    @ApiOperation(value = "运营商注册(没有通过任何人拉取的，自己找到平台来注册的)",notes = "运营商注册(没有通过任何人拉取的，自己找到平台来注册的)")
    @PostMapping(value = "/registerOperator")
    public Result<Boolean> registerOperator(@RequestBody ClientHandleOperator clientHandleOperator) {
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.registerOperator(handleOperator);
    }

    /**
     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     * @author donghuan
     */
    @ApiOperation(value = "运营商注册（有人拉的，手机与名字都有,只需要设置密码就可以完成登陆)",notes = "运营商注册（有人拉的，手机与名字都有,只需要设置密码就可以完成登陆)")
    @PostMapping(value = "/addPasswordOperator")
    public Result<Boolean> addPasswordOperator(@RequestBody ClientHandleOperator clientHandleOperator){
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.addPasswordOperator(handleOperator);
    }

    /**
     *   忘记密码
     *  @author donghuan
     */
    @ApiOperation(value = "忘记密码",notes = "修改密码")
    @PostMapping(value = "/forgetPasswordOperator")
    public Result<Boolean> forgetPassword(@RequestBody ClientHandleOperatorForgetPassword clientHandleOperatorForgetPassword) {
        HandleOperatorForgetPassword handleOperatorForgetPassword=new HandleOperatorForgetPassword();
        BeanUtils.copyProperties(clientHandleOperatorForgetPassword,handleOperatorForgetPassword);
        return operatorClient.forgetPassword(handleOperatorForgetPassword);
    }

    /**
     * 依据id查询已经登陆的个人信息
     * @author donghuan
     */
    @ApiOperation(value = "依据id查询已经登陆的个人信息",notes = "依据id查询已经登陆的个人信息")
    @PostMapping(value = "/findByNameOperator")
    public Result<OperatorBasicInfoVO> findByName(@RequestBody ClientHandleOperatorId clientHandleOperatorId) {
        HandleOperatorId handleOperatorId=new HandleOperatorId();
        BeanUtils.copyProperties(clientHandleOperatorId,handleOperatorId);
        return operatorClient.findByName(handleOperatorId);
    }

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    @ApiOperation(value = "运营商新增自己的员工",notes = "运营商新增自己的员工")
    @PostMapping(value = "/createOperatorEmployee")
    public Result<Boolean> createOperatorEmployee(@RequestBody ClientHandleOperatorAddEmployee clientHandleOperatorAddEmployee){
        HandleOperatorAddEmployee handleOperatorAddEmployee=new HandleOperatorAddEmployee();
        BeanUtils.copyProperties(clientHandleOperatorAddEmployee,handleOperatorAddEmployee);
        return operatorClient.createOperatorEmployee(handleOperatorAddEmployee);
    }

    /**
     *  根据员工的id来更新该员工的个人信息
     *  @author donghuan
     */
    @ApiOperation(value = "根据员工的id来更新该员工的个人信息",notes = "根据员工的id来更新该员工的个人信息")
    @PostMapping(value = "/updateOperatorEmployeeById")
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody ClientHandleOperatorUpdateEmployeeById clientHandleOperatorUpdateEmployeeById){
        HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById=new HandleOperatorUpdateEmployeeById();
        BeanUtils.copyProperties(clientHandleOperatorUpdateEmployeeById,handleOperatorUpdateEmployeeById);
        return operatorClient.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**
     * 依据id来删除一个员工
     * @author donghuan
     */
    @ApiOperation(value = "依据id来删除一个员工",notes = "依据id来删除一个员工")
    @PostMapping(value = "/deleteOperatorEmployeeById")
    public Result<Boolean> deleteOperatorEmployeeById(@RequestBody ClientHandleOperatorId clientHandleOperatorId){
        HandleOperatorId handleOperatorId=new HandleOperatorId();
        BeanUtils.copyProperties(clientHandleOperatorId,handleOperatorId);
        return operatorClient.deleteOperatorEmployeeById(handleOperatorId);
    }

    /**
     *  通过id来改变员工的状态,是否禁用
     * @author donghuan
     */
    @ApiOperation(value = "通过id来改变员工的状态,是否禁用",notes = "通过id来改变员工的状态,是否禁用")
    @PostMapping(value = "/updateOperatorEmployeeByisDeleted")
    public Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody ClientHandleOperatorId clientHandleOperatorId){
        HandleOperatorId handleOperatorId=new HandleOperatorId();
        BeanUtils.copyProperties(clientHandleOperatorId,handleOperatorId);
        return operatorClient.updateOperatorEmployeeByisDeleted(handleOperatorId);
    }

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @ApiOperation(value = "通过id来修改对应的state",notes = "通过id来修改对应的state")
    @PostMapping(value = "/updateOperatorEmployeeStateById")
    public Result<Boolean> updateOperatorEmployeeStateById(@RequestBody ClientHandleOperatorState clientHandleOperatorState){
        HandleOperatorState handleOperatorState=new HandleOperatorState();
        BeanUtils.copyProperties(clientHandleOperatorState,handleOperatorState);
        return operatorClient.updateOperatorEmployeeStateById(handleOperatorState);
    }

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @ApiOperation(value = "根据用户id来修改他的role ",notes = "根据用户id来修改他的role ")
    @PostMapping(value = "/updateOperatorEmployeeRoleById")
    public Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody ClientHandleOperatorRole clientHandleOperatorRole){
        HandleOperatorRole handleOperatorRole=new HandleOperatorRole();
        BeanUtils.copyProperties(clientHandleOperatorRole,handleOperatorRole);
        return operatorClient.updateOperatorEmployeeRoleById(handleOperatorRole);
    }

    /**
     * 依据电话来删除一个员工
     *  @author donghuan
     */
    @ApiOperation(value = "依据电话来删除一个员工",notes = "依据电话来删除一个员工")
    @PostMapping(value = "/deleteOperatorEmployeeByCellphone")
    Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
        return operatorClient.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
    }

    /**
     * 根据电话来查找一条记录,返回一个真假值
     * @author donghuan
     */
    @ApiOperation(value = "根据电话来查找一条记录,返回一个真假值",notes = "根据电话来查找一条记录,返回一个真假值")
    @PostMapping(value = "/findOperatorRecordByCellphone")
    Result<Boolean> findOperatorRecordByCellphone(@RequestBody ClientHandleOperatorCellphone clientHandleOperatorCellphone){
        HandleOperatorCellphone handleOperatorCellphone=new HandleOperatorCellphone();
        BeanUtils.copyProperties(clientHandleOperatorCellphone,handleOperatorCellphone);
        return operatorClient.findOperatorRecordByCellphone(handleOperatorCellphone);
    }


    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    @ApiOperation(value = "依据供应商输入的员工姓名来模糊匹配",notes = "依据供应商输入的员工姓名来模糊匹配")
    @PostMapping(value = "/queryOperatorEmployeeAll")
    public Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(@RequestBody ClientHandleOperatorFindAllByName clientHandleOperatorFindAllByName){
        HandleOperatorFindAllByName handleOperatorFindAllByName=new HandleOperatorFindAllByName();
        BeanUtils.copyProperties(clientHandleOperatorFindAllByName,handleOperatorFindAllByName);
        return operatorClient.queryOperatorEmployeeAll(handleOperatorFindAllByName);
    }

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @ApiOperation(value = "运营商新增供应商",notes = "运营商添加供应商到公库与私库")
    @PostMapping(value = "/createSupplierByOperator")
    public Result<Boolean> createSupplierByOperator(@RequestBody ClientHandleCreateSupplerByOperator clientHandleCreateSupplerByOperator) {
        HandleCreateSupplerByOperator handleCreateSupplerByOperator=new HandleCreateSupplerByOperator();
        BeanUtils.copyProperties(clientHandleCreateSupplerByOperator,handleCreateSupplerByOperator);
        return operatorClient.createSupplierByOperator(handleCreateSupplerByOperator);
    }



    /**
    * @Description:    运营商新增采购人
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 10:34
    * @UpdateUser:     donghuan
    * @UpdateDate:     2018/9/13 10:34
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    @ApiOperation(value = "运营商添加采购人",notes = "运营商添加采购人")
    @PostMapping(value = "/createPurchaseByOperator")
    public Result<Boolean> createPurchaseByOperator(@RequestBody ClientHandleCreatePurchaserByOperator clientHandleCreatePurchaserByOperator) {
        HandleCreatePurchaserByOperator handleCreatePurchaserByOperator=new HandleCreatePurchaserByOperator();
        BeanUtils.copyProperties(clientHandleCreatePurchaserByOperator,handleCreatePurchaserByOperator);
        return operatorClient.createPurchaseByOperator(handleCreatePurchaserByOperator);
    }


}
