package com.epc.mobile.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Description : 保证金
 * <p>Date : 2018-09-25 13:43
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleBidsGuaranteeAmount",description = "保证金")
public class ClientHandleBidsGuaranteeAmount {

    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "发售招标文件表主键ID")
    private Long bIssueDocumentsId;
    @ApiModelProperty(value = "投标保证金")
    private BigDecimal tenderGuaranteeAmount;
    @ApiModelProperty(value = "标段名称")
    private String bidsName;
    @ApiModelProperty(value = "标段编号")
    private String bidsCode;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "收款单位")
    private String receivables;
    @ApiModelProperty(value = "开户行帐号")
    private String bankAccount;

}
