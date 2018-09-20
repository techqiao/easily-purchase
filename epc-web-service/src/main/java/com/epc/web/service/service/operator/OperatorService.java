package com.epc.web.service.service.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.operator.handle.HandleOperatorAddEmployee;
import com.epc.web.facade.operator.handle.HandleOperatorFindAllByName;
import com.epc.web.facade.operator.handle.HandleOperatorUpdateEmployeeById;
import com.epc.web.facade.operator.vo.OperatorBasicInfoVO;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;
import com.epc.web.service.domain.operator.TOperatorBasicInfo;

import java.util.List;

public interface OperatorService {
    /**
     * 新增运营商人员
     * @param handleOperator
     * @return
     */
    Result<Boolean> createOperatorBasicInfo(HandleOperator handleOperator);

    /**
     * 新增采购人
     * @param handlePurchaser
     * @return
     */
    Result<Boolean> createPurchaseByOperator(HandlePurchaser handlePurchaser);


    /*=================================================*/

    /**
     * 运营商新增自己的员工
     * @author donghuan
     * @return
     */
    Result<Boolean> createOperatorEmployee(HandleOperatorAddEmployee handleOperatorAddEmployee);

    /**
     *  根据员工的id来更新该员工的个人信息
     * @author donghuan
     * @param handleOperatorUpdateEmployeeById
     * @return
     */
    Result<Boolean> updateOperatorEmployeeById(HandleOperatorUpdateEmployeeById handleOperatorUpdateEmployeeById);

    /**
     *  依据供应商输入的员工姓名来模糊匹配
     * @author donghuan
     * @param handleOperatorFindAllByName
     * @return
     */
    Result<List<OperatorBasicInfoVO>>  queryOperatorEmployeeAll(HandleOperatorFindAllByName handleOperatorFindAllByName);


}
