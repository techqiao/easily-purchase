package com.epc.web.facade.terdering.purchase.handle;

import com.epc.web.facade.terdering.participant.handle.HandleParticipantBasicInfo;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 10:36
 * <p>@Author : wjq
 */
@Data
public class HandlePurchaseProjectBasicInfoSub extends HandlePurchaseProjectBasicInfo{
    /**
     * 采购项目参与者
     */
    private List<HandleParticipantBasicInfo> handleParticipantBasicInfoList;


}
