package com.epc.user.service.service.operator;

import com.epc.common.Result;
import com.epc.web.facade.operator.handle.HandleOperator;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;

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

}
