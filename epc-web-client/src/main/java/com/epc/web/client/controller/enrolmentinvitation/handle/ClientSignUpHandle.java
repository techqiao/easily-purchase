package com.epc.web.client.controller.enrolmentinvitation.handle;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:03
 * <p>@Author : luozhixin
 * <p>ClientSignUpHandle
 */
@Data
@ApiModel("公告报名")
public class ClientSignUpHandle implements Serializable {
    private static final long serialVersionUID = -8362626050903023605L;
    @ApiModelProperty("项目id")
    private Long projectId;
    @ApiModelProperty("采购项目id")
    private Long procurementProjectId;
    @ApiModelProperty("标段id列表拼接")
    private String  bidsId;
    @ApiModelProperty("标段名称列表拼接")
    private String  bidsName;
    @ApiModelProperty("签到类型(0-公告，1-私有)")
    private Integer signUpType;
}
