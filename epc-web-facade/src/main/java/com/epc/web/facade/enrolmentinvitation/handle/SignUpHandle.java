package com.epc.web.facade.enrolmentinvitation.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:13
 * <p>@Author : luozhixin
 * <p>SignUpHandle
 */
@Data
public class SignUpHandle implements Serializable {
    private static final long serialVersionUID = -3782652077490872144L;

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
    /**
     * 标段id列表拼接
     */
    private String  bidsId;
    /**
     * 标段名称列表拼接
     */
    private String  bidsName;


    private Long userId;

}
