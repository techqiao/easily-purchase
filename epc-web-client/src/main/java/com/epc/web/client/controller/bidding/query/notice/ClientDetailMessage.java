package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("招标文件详情")
public class ClientDetailMessage implements Serializable {
    private static final long serialVersionUID = 4898189430038003246L;
    @ApiModelProperty("采购项目id")
    private Long procurementProjectId;
}
