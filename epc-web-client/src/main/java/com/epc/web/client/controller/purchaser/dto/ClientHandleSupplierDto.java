package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientHandleSupplierDto",description = "采购人完善供货省信息和供货商信息查询")
public class ClientHandleSupplierDto implements Serializable {
    private static final long serialVersionUID = -7953799077702459394L;
    /**
     * 采购人id
     */
    @ApiModelProperty(value = "采购人id")
    private Long purcharseId;
    /**
     * 供货商公司姓名
     */
    @ApiModelProperty(value = "供货商公司name")
    private String companyName;
}
