package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "ClientQueryDto",description = "用户综合条件查询")
public class ClientQueryDto implements Serializable {
    private static final long serialVersionUID = 4468039897804940011L;
    @ApiModelProperty(value = "用户id")
    private Long userId;
}
