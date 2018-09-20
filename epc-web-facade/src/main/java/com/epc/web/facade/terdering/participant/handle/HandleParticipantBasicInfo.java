package com.epc.web.facade.terdering.participant.handle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 09:52
 * <p>@Author : wjq
 */
@Data
public class HandleParticipantBasicInfo implements Serializable {
    private static final long serialVersionUID = -8974203125944337113L;
    /**
     * 采购项目ID
     */
    private Long purchaseProjectId;
    /**
     * 参与者ID
     */
    private Long userId;
    /**
     * 参与者姓名
     */
    private String userName;
    /**
     * 参与者电话
     */
    private String userPhone;
    /**
     * 参与者机构ID
     */
    private Long userAgencyId;
    /**
     * 参与者机构名称
     */
    private String agencyName;

    /**
     * 经办人 审核人类型
     */
    private String type;

}
