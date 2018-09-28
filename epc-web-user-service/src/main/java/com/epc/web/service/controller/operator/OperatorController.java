package com.epc.web.service.controller.operator;


import com.epc.common.Result;
import com.epc.web.facade.operator.FacadeOperatorService;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.PurchaserHandleSupplierDto;
import com.epc.web.service.service.operator.OperatorService;
import com.epc.web.service.service.purchaser.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>Description : 运营商控制器
 * <p>Date : 2018-09-10  18:08
 */
@RestController
public class OperatorController implements FacadeOperatorService {

    @Autowired
    private OperatorService operatorService;

    /**
     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     * @author donghuan
     */
    @Override
    public Result<Boolean> registerOperator(@RequestBody  HandleOperator handleOperator) {
        return operatorService.registerOperator(handleOperator);
    }

    /**
     * 运营商注册,(有人拉的，手机与名字都有,只需要设置密码就可以登陆)
     * @author donghuan
     */
    @Override
    public Result<Boolean> addPasswordOperator(@RequestBody  HandleOperator handleOperator) {
        return operatorService.addPasswordOperator(handleOperator);
    }

    /**
     * 查询运营商用户信息
     * @author donghuan
     */
    @Override
    public  Result<OperatorBasicInfoVO> findByName(@RequestBody HandleOperatorId handleOperatorId) {
        return operatorService.findByName(handleOperatorId);
    }

    /**
     * 忘记密码
     * @author donghuan
     */
    @Override
    public Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword) {
        return operatorService.forgetPassword(handleOperatorForgetPassword);
    }

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    @Override
    public Result<Boolean> createOperatorEmployee(@RequestBody HandleOperatorAddEmployee handleOperatorAddEmployee) {
        return operatorService.createOperatorEmployee(handleOperatorAddEmployee);
    }

    /**
     * 依据id来删除一个员工
     */
    @Override
    public Result<Boolean> deleteOperatorEmployeeById(@RequestBody HandleOperatorId handleOperatorId){
        return operatorService.deleteOperatorEmployeeById(handleOperatorId);
    }

    /**
     *  通过id来改变员工的状态,是否禁用
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody HandleOperatorId handleOperatorId){
        return operatorService.updateOperatorEmployeeByisDeleted(handleOperatorId);
    }

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState){
        return operatorService.updateOperatorEmployeeStateById(handleOperatorState);
    }

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole) {
        return operatorService.updateOperatorEmployeeRoleById(handleOperatorRole);
    }

    /**
     * 依据电话来删除一个员工
     *  @author donghuan
     */
    @Override
    public Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone){
        return operatorService.deleteOperatorEmployeeByCellphone(handleOperatorCellphone);
    }

    /**
     * 根据电话来查找一条记录,返回一个真假值
     * @author donghuan
     */
    @Override
    public Result<Boolean> findOperatorRecordByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone){
        return operatorService.findOperatorRecordByCellphone(handleOperatorCellphone);
    }


    /**
     *  根据员工的id来更新该员工的个人信息
     *  @author donghuan
     */
    @Override
    public Result<Boolean> updateOperatorEmployeeById(@RequestBody HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById) {
        return operatorService.updateOperatorEmployeeById(handleOperatorUpdateEmployeeById);
    }

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    @Override
    public Result<List<OperatorBasicInfoVO>> queryOperatorEmployeeAll(@RequestBody HandleOperatorFindAllByName handleOperatorFindAllByName) {
        return operatorService.queryOperatorEmployeeAll(handleOperatorFindAllByName);
    }



    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @Override
    public Result<Boolean> createSupplierByOperator(@RequestBody HandleCreateSupplerByOperator handleCreateSupplerByOperator) {
        return operatorService.createSupplierByOperator(handleCreateSupplerByOperator);
    }

    /**
     * @Description:    运营商新增采购人
     */

    @Override
    public Result<Boolean> createPurchaseByOperator(@RequestBody HandleCreatePurchaserByOperator handleCreatePurchaserByOperator) {
        return operatorService.createPurchaseByOperator(handleCreatePurchaserByOperator);
    }

}
