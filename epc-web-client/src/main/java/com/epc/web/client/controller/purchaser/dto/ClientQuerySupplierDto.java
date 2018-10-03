package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientQuerySupplierDto",description = "供应商查询条件")
public class ClientQuerySupplierDto implements Serializable{
    private static final long serialVersionUID = 4364609040084509797L;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "采购人机构id")
    private Long purchaserId;
    /**
     * 供应商名字
     */
    @ApiModelProperty(value = "供货商公司")
    private String name;
}
