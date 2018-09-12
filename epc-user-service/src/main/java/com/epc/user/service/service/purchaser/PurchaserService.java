package com.epc.user.service.service.purchaser;

import com.epc.user.service.domain.handle.operator.HandleOperator;
import com.epc.user.service.domain.handle.purchaser.HandlePurchaser;

public interface PurchaserService {
    /**
     * 新增采购人
     */

    Boolean createPurchaserUserInfo(HandlePurchaser handleOperator);
}
