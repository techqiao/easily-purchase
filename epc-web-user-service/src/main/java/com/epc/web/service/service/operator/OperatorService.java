package com.epc.web.service.service.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;

import java.util.List;

public interface OperatorService {

    /**
     * 运营商注册(没有通过任何人拉取的，自己找到平台来注册的)
     * @author donghuan
     */
    Result<Boolean> registerOperator(HandleOperator handleOperator);

    /**
     *  运营商注册,(有人拉的，手机与名字都有,只需要设置密码就可以登陆)
     * @author donghuan
     */
    Result<Boolean> addPasswordOperator(HandleOperator handleOperator);

    /**
     * 查询运营商用户信息
     * @author donghuan
     */
    Result<OperatorBasicInfoVO> findByName(HandleOperatorId handleOperatorId);

    /**
     * 忘记密码
     * @author donghuan
     */
    Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword);

    /**
     * 运营商新增自己的员工
     * @author donghuan
     */
    Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**
     *  根据员工的id来更新该员工的个人信息
     *  @author donghuan
     */
    Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**
     * 依据id来删除一个员工
     * @author donghuan
     */
    Result<Boolean> deleteOperatorEmployeeById(HandleOperatorId handleOperatorId);

    /**
     * 通过id来修改对应的state  0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     * @author donghuan
     */
    Result<Boolean> updateOperatorEmployeeStateById(HandleOperatorState handleOperatorState);

    /**
     * 根据用户id来修改他的role 用户角色:0-法人,1-管理员,2-普通员工'
     * @author donghuan
     */
    Result<Boolean> updateOperatorEmployeeRoleById(HandleOperatorRole handleOperatorRole);

    /**
     * 依据电话来删除一个员工
     *  @author donghuan
     */
    Result<Boolean> deleteOperatorEmployeeByCellphone(HandleOperatorCellphone handleOperatorCellphone);

    /**
     *  通过id来改变员工的状态,是否禁用
     * @author donghuan
     */
    Result<Boolean> updateOperatorEmployeeByisDeleted(HandleOperatorId handleOperatorId);

    /**
     * 根据电话来查找一条记录,返回一个真假值
     * @author donghuan
     */
    Result<Boolean> findOperatorRecordByCellphone(HandleOperatorCellphone handleOperatorCellphone);

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     *  @author donghuan
     */
    Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName);


    /**
     * 运营商新增采购人
     * @return
     */
    Result<Boolean> createPurchaseByOperator(HandleCreatePurchaserByOperator handleCreatePurchaserByOperator);

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    Result<Boolean> createSupplierByOperator(HandleCreateSupplerByOperator handleCreateSupplerByOperator);




}
