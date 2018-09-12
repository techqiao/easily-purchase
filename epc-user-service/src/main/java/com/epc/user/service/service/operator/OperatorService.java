package com.epc.user.service.service.operator;

import com.epc.user.service.domain.handle.operator.HandleOperator;

public interface OperatorService {
    /**
     * 创建运营人员
     */

    Boolean createOperatorUserInfo(HandleOperator handleOperator);

    void createOperatorUser(HandleOperator handleOperator,Long userId);

   // Boolean createPurchaserUserInfo(HandleOperator handleOperator);
}
