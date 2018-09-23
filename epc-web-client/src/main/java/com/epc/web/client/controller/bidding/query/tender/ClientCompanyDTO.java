package com.epc.web.client.controller.bidding.query.tender;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "供应商机构Id")
@Data
public class ClientCompanyDTO {
    @ApiModelProperty(value = "供应商机构ID")
    private Long supplierId;
}
