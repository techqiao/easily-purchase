package com.epc.web.client.controller.enrolmentinvitation.handle;

import lombok.Data;

@Data
public class ClientInvitation {
    private Long id;
    private Boolean status;
    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 采购项目ID
     */
    private Long procurementProjectId;

    /**
     *报名类型： 0-公告 1-私有
     */
    private Integer signUpType;

    private Long supplierId;
}
