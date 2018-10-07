package com.epc.web.facade.enrolmentinvitation.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:34
 * <p>@Author : luozhixin
 * <p>InvitationHandle
 */
@Data
public class InvitationHandle implements Serializable {
    private static final long serialVersionUID = 8754379024086078602L;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 采购项目Id
     */
    private Long procurementProjectId;

    /**
     * 采购法人Id
     */
    private Long purchaserId;
    /**
     * 供应商列表
     */
    private List<Long> supplierList;
    /**
     * 标段id列表拼接
     */
    private String  bidsId;
    /**
     * 标段名称列表拼接
     */
    private String  bidsName;

    /**
     * 邀请内容
     */
    private String  content;

}
