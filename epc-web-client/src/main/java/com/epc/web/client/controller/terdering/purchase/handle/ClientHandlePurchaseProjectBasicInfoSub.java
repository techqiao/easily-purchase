package com.epc.web.client.controller.terdering.purchase.handle;

import com.epc.web.facade.terdering.participant.handle.HandleParticipantBasicInfo;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 10:36
 * <p>@Author : wjq
 */
@Data
public class ClientHandlePurchaseProjectBasicInfoSub extends ClientHandlePurchaseProjectBasicInfo{
    /**
     * 采购项目参与者
     */
    private HandleParticipantBasicInfo handleParticipantBasicInfo;


}
