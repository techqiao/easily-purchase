package com.epc.web.client.controller.enrolmentinvitation.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-05 16:33
 * <p>@Author : luozhixin
 * <p>ClientInvitationHandle
 */
@Data
@ApiModel("采购人邀请供应商")
public class ClientInvitationHandle implements Serializable {
    private static final long serialVersionUID = -3727333049885772895L;
    @ApiModelProperty("项目id")
    private Long projectId;
    @ApiModelProperty("采购项目id")
    private Long procurementProjectId;
    @ApiModelProperty("标段id列表拼接")
    private String  bidsId;
    @ApiModelProperty("标段名称列表拼接")
    private String  bidsName;
    @ApiModelProperty("邀请的供应商List")
    private List<Long> supplierList;
    @ApiModelProperty("邀请内容")
    private String  content;
}
