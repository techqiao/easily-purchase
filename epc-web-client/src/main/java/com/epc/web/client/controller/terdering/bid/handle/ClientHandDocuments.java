package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 14:15
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandDocuments",description = "处理招标文件")
public class ClientHandDocuments {
    @ApiModelProperty(value = "标段保证金集合")
    private List<ClientHandleBidsGuaranteeAmount> clientHandleBidsGuaranteeAmounts;
    @ApiModelProperty(value = "招标文件")
    private ClientHandleSaleDocuments clientHandleSaleDocuments;
    @ApiModelProperty(value = "线下招标文件")
    private ClientHandleUnderLine clientHandleUnderLine;

}
