package com.epc.user.service.service.purchaser;

import com.epc.common.Result;
import com.epc.web.facade.purchaser.handle.HandlePurchaser;

public interface PurchaserService {
    /**
     * 新增采购人
     */

    Result<Boolean> createPurchaserUserInfo(HandlePurchaser handleOperator, int roleType);

    /**
     * 添加运营商-采购人关系
     * @param handleOperator
     * @return
     */
    Result<Boolean> createOperatePurchaser(HandlePurchaser handleOperator);


}
