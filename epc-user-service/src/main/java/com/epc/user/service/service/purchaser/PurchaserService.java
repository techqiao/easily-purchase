package com.epc.user.service.service.purchaser;

import com.epc.web.facade.purchaser.handle.HandlePurchaser;

public interface PurchaserService {
    /**
     * 新增采购人
     */

    void createPurchaserUserInfo(HandlePurchaser handleOperator);
}
