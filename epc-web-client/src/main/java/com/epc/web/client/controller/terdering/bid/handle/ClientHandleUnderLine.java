package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Description : 线下招标文件
 * <p>Date : 2018-09-25 14:08
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleUnderLine",description = "线下招标文件")
public class ClientHandleUnderLine {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "发售招标文件表主键ID")
    private Long bIssueDocumentsId;
    @ApiModelProperty(value = "发售开始时间")
    private Date saleTimeStart;
    @ApiModelProperty(value = "发售截止时间")
    private Date saleTimeEnd;
    @ApiModelProperty(value = "发售地点")
    private String place;
    @ApiModelProperty(value = "金额")
    private BigDecimal price;
    @ApiModelProperty(value = "联系人")
    private String contactsName;
    @ApiModelProperty(value = "联系电话")
    private String contactNumber;
    @ApiModelProperty(value = "备注")
    private String remarks;
}
