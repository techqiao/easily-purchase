package com.epc.web.client.controller.agency.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientSupplierDto",description = "条件查询供货商")
public class ClientSupplierDto implements Serializable {
    private static final long serialVersionUID = 145508941780239327L;
//    /**
//     * 代理机构id
//     */
//    @ApiModelProperty(value = "代理机构id")
//    @NotEmpty(message = "ClientSupplierDto.agencyId.null")
//    private Long agencyId;
     /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    /**
     * 供应商id
     */
    @ApiModelProperty(value = "供应商id")
    private  Long supplierId;
}
