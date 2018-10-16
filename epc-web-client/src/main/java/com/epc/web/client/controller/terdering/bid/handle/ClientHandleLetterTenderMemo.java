package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-15 14:20
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "唱标确认")
public class ClientHandleLetterTenderMemo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "唱标备注")
    private String memo;
}
