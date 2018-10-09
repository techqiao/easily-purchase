package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientQueryAgencyDto",description = "代理机构查询条件")
public class ClientQueryAgencyDto implements Serializable {
    private static final long serialVersionUID = -2313595457045686214L;
    /**
     * 机构id
     */
//    @ApiModelProperty(value = "采购人id")
//    @NotEmpty(message = "ClientQueryAgencyDto.purchaserId.null")
//    private Long purchaserId;
    /**
     * 代理机构名字
     */
    @ApiModelProperty(value = "代理机构公司名")
    private String name;
    /**
     * 代理机构id
     */
    @ApiModelProperty(value = "代理机构id")
    private Long agencyId;

}
