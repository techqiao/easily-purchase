package com.epc.web.facade.operator;

import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.facade.purchaser.handle.PurchaserHandleSupplierDto;
import com.epc.web.facade.supplier.handle.HandleSupplierDetail;
import org.springframework.web.bind.annotation.PostMapping;
import com.epc.common.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description:    运营商服务
 * @Author:         linzhixiang
 * @CreateDate:     2018/9/13 9:50
 * @UpdateUser:     linzhixiang
 * @UpdateDate:     2018/9/13 9:50
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */

public interface FacadeOperatorService {


    /**
     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     * @author donghuan
     */
    @PostMapping(value = "registerOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> registerOperator(@RequestBody HandleOperator handleOperator);

    /**
     * 运营商注册,(有人拉的，手机与名字都有,只需要设置密码就可以登陆)
     * @author donghuan
     */
    @PostMapping(value = "addPasswordOperator",consumes = "application/json; charset=UTF-8")
    Result<Boolean> addPasswordOperator(@RequestBody  HandleOperator handleOperator);

    /**
     * 忘记密码
     * @author donghuan
     */
    @PostMapping(value = "forgetPasswordOperator", consumes = "application/json; charset=UTF-8")
    Result<Boolean> forgetPassword(@RequestBody HandleOperatorForgetPassword handleOperatorForgetPassword);

    /**
     * 依据用户id查询用户基本信息
     * @author donghuan
     */
    @PostMapping(value = "findByNameOperator", consumes = "application/json; charset=UTF-8")
    Result<OperatorBasicInfoVO> findByName(@RequestBody HandleOperatorId handleOperatorId);

    /**
     * 依据id来删除一个员工
     * @author donghuan
     */
    @PostMapping(value = "deleteOperatorEmployeeById", consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteOperatorEmployeeById(@RequestBody HandleOperatorId handleOperatorId);

    /**
     *  通过id来改变员工的状态,是否禁用
     * @author donghuan
     */
    @PostMapping(value = "updateOperatorEmployeeByisDeleted",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeByisDeleted(@RequestBody HandleOperatorId handleOperatorId);

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    @PostMapping(value = "updateOperatorEmployeeStateById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeStateById(@RequestBody HandleOperatorState handleOperatorState);

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    @PostMapping(value = "updateOperatorEmployeeRoleById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeRoleById(@RequestBody HandleOperatorRole handleOperatorRole);


    /**
     * 依据电话来删除一个员工
     *  @author donghuan
     */
    @PostMapping(value = "deleteOperatorEmployeeByCellphone",consumes = "application/json; charset=UTF-8")
    Result<Boolean> deleteOperatorEmployeeByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone);

    /**
     * 根据电话来查找一条记录,返回一个真假值
     * @author donghuan
     */
    @PostMapping(value = "findOperatorRecordByCellphone",consumes = "application/json; charset=UTF-8")
    Result<Boolean> findOperatorRecordByCellphone(@RequestBody HandleOperatorCellphone handleOperatorCellphone);

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    @PostMapping(value = "createOperatorEmployee",consumes = "application/json; charset=UTF-8")
    Result<Boolean> createOperatorEmployee(@RequestBody HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**
     *  根据员工的id来更新该员工的个人信息
     *  @author donghuan
     */
    @PostMapping(value = "updateOperatorEmployeeById",consumes = "application/json; charset=UTF-8")
    Result<Boolean> updateOperatorEmployeeById(@RequestBody HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    @PostMapping(value = "queryOperatorEmployeeAll",consumes = "application/json; charset=UTF-8")
    Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(@RequestBody HandleOperatorFindAllByName handleOperatorFindAllByName);

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    @PostMapping(value = "createSupplierByOperator",consumes = "application/json;charset=UTF-8")
    Result<Boolean> createSupplierByOperator(@RequestBody HandleCreateSupplerByOperator handleCreateSupplerByOperator);

    /**
     * 运营商 注册采购人
     * @return
     */
    @PostMapping(value = "createPurchaseByOperator", consumes = "application/json; charset=UTF-8")
    Result<Boolean> createPurchaseByOperator(@RequestBody HandleCreatePurchaserByOperator handleCreatePurchaserByOperator);


}
