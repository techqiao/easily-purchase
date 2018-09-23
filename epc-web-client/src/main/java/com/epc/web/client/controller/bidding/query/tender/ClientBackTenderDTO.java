package com.epc.web.client.controller.bidding.query.tender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "查询标段保证金退还情况",description = "查询标段保证金退还情况")
public class ClientBackTenderDTO {
    private static final long serialVersionUID = -966103363414203576L;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "供应商ID")
    private Long tendererCompanyId;
}
