package com.epc.web.facade.enrolmentinvitation.handle;

import lombok.Data;

import java.io.Serializable;
@Data
public class UpdateInvitation implements Serializable {
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

    /**
     * 供应商ID
     */
    private Long supplierId;
}
