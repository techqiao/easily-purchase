package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "确定中标人和中标通知书路径")
public class ClientWinBidding implements Serializable {
    @ApiModelProperty(value = "报告ID")
    private Long id;
    @ApiModelProperty(value = "中标人Id")
    private Long supplierId;
    @ApiModelProperty(value = "中标通知书路径")
    private String filePath;
}
