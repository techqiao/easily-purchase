package com.epc.web.facade.bidding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class SupplierSignDTO implements Serializable {
    @ApiModelProperty("供应商id")
    private Long supplierId;
    @ApiModelProperty("供应商名称")
    private String supplierName;
    @ApiModelProperty("报名时间")
    private String SignUpTime;
}
