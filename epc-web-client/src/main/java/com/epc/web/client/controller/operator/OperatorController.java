package com.epc.web.client.controller.operator;

import com.epc.common.Result;
import com.epc.web.client.controller.operator.handle.*;
import com.epc.web.client.controller.purchaser.handle.ClientHandlePurchaser;
import com.epc.web.client.controller.supplier.handle.ClientHandleSupplierDetail;
import com.epc.web.client.remoteApi.operator.OperatorClient;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.purchaser.handle.PurchaserHandleSupplierDto;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "运营商服务")
@RestController
@RequestMapping(value = "/operator", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OperatorController {

    @Autowired
    private OperatorClient operatorClient;

    /**
     * 注册运营商
     * @author donghuan
     */
    @ApiOperation(value = "运营商注册",notes = "运营商注册")
    @PostMapping(value = "/registerOperator")
    public Result<Boolean> registerOperator(@RequestBody ClientHandleOperator clientHandleOperator) {
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.registerOperator(handleOperator);
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
     * 查询用户信息
     * @author donghuan
     */
    @ApiOperation(value = "登陆人的信息",notes = "依据名字，电话得到个人信息")
    @PostMapping(value = "/findByNameOperator")
    public Result<OperatorBasicInfoVO> findByName(@RequestBody ClientHandleOperator clientHandleOperator) {
        HandleOperator handleOperator=new HandleOperator();
        BeanUtils.copyProperties(clientHandleOperator,handleOperator);
        return operatorClient.findByName(handleOperator);
    }

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    @ApiOperation(value = "运营商新增自己的员工",notes = "运营商新增自己的员工")
    @PostMapping(value = "createOperatorEmployee",consumes = "application/json; charset=UTF-8")
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
    @PostMapping(value = "updateOperatorEmployeeById",consumes = "application/json; charset=UTF-8")
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody ClientHandleOperatorUpdateEmployeeById clientHandleOperatorUpdateEmployeeById){
        HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById=new HandleOperatorUpdateEmployeeById();
        BeanUtils.copyProperties(clientHandleOperatorUpdateEmployeeById,handleOperatorUpdateEmployeeById);
        return operatorClient.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    @ApiOperation(value = "依据供应商输入的员工姓名来模糊匹配",notes = "依据供应商输入的员工姓名来模糊匹配")
    @PostMapping(value = "queryOperatorEmployeeAll",consumes = "application/json; charset=UTF-8")
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
    @PostMapping(value = "createSupplierByOperator",consumes = "application/json; charset=UTF-8")
    public Result<Boolean> createSupplierByOperator(@RequestBody ClientHandleCreateSupplerByOperator clientHandleCreateSupplerByOperator) {
        HandleCreateSupplerByOperator handleCreateSupplerByOperator=new HandleCreateSupplerByOperator();
        BeanUtils.copyProperties(clientHandleCreateSupplerByOperator,handleCreateSupplerByOperator);
        return operatorClient.createSupplierByOperator(handleCreateSupplerByOperator);
    }



    /**
    * @Description:    运营商新增采购人
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/13 10:34
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/13 10:34
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */

    @ApiOperation(value = "运营商添加采购人",notes = "运营商添加采购人")
    @PostMapping(value = "/createPurchaseByOperator")
    public Result<Boolean> createPurchaseByOperator(@RequestBody ClientHandlePurchaser clientHandlePurchaser) {
        HandlePurchaser handleOperator=new HandlePurchaser();
        BeanUtils.copyProperties(clientHandlePurchaser,handleOperator);
        return operatorClient.createPurchaseByOperator(handleOperator);
    }


    /**
    * @Description:    完善供应商信息
    * @Author:         linzhixiang
    * @CreateDate:     2018/9/14 19:21
    * @UpdateUser:     linzhixiang
    * @UpdateDate:     2018/9/14 19:21
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @ApiOperation(value = "完善供应商信息",notes = "完善供应商信息")
    @PostMapping(value = "/updateSupplierDetail")
    public Result<Boolean> updateSupplierDetail(@RequestBody ClientHandleSupplierDetail clientHandleSupplierDetail) {
        PurchaserHandleSupplierDto handleSupplierDetail=new PurchaserHandleSupplierDto();
        BeanUtils.copyProperties(clientHandleSupplierDetail,handleSupplierDetail);
        return operatorClient.updateSupplierDetail(handleSupplierDetail);
    }
}
