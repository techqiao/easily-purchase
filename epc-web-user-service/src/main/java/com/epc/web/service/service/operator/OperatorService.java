package com.epc.web.service.service.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.*;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;

import java.util.List;

public interface OperatorService {

    /**
     * 注册运营商
     */
    Result<Boolean> registerOperator(HandleOperator handleOperator);

    /**
     * 查询运营商用户信息
     */
    Result<OperatorBasicInfoVO> findByName(HandleOperator handleOperator);

    /**
     * 忘记密码
     */
    Result<Boolean> forgetPassword(HandleOperatorForgetPassword handleOperatorForgetPassword);

    /**
     * 运营商新增自己的员工
     */
    Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**
     *  根据员工的id来更新该员工的个人信息
     */
    Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     */
    Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName);


    /**
     * 新增采购人
     * @param handlePurchaser
     * @return
     */
    Result<Boolean> createPurchaseByOperator(HandlePurchaser handlePurchaser);

    /**
     *  运营商新增供应商
     * @author donghuan
     */
    Result<Boolean> createSupplierByOperator(HandleCreateSupplerByOperator handleCreateSupplerByOperator);




}
