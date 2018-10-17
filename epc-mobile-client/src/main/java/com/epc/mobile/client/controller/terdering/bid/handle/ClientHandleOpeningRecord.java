package com.epc.mobile.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p>Description : 开标记录
 * <p>Date : 2018-09-26 10:05
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleOpeningRecord",description = "开标记录")
public class ClientHandleOpeningRecord {
    @ApiModelProperty(value = "主键ID 修改时传")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private Long purchaseProjectId;
    @ApiModelProperty(value = "提交投标文件ID")
    private Long tenderMessageId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "投标单位名称ID 供应商ID")
    private Long supplierCompanyId;
    @ApiModelProperty(value = "投标单位名称(供应商名称)")
    private String supplierCompanyName;
    @ApiModelProperty(value = "是否缴纳保证金 0 否 1是")
    private Integer isPayBond;
    @ApiModelProperty(value = "是否签到 0 否 1是")
    private Integer isSign;
    @ApiModelProperty(value = "标书封装检查是否合格 0 否 1是")
    private Integer isBiddingQualified;
    @ApiModelProperty(value = "是否拒收标书 0 否 1是")
    private Integer isBiddingRefuse;
    @ApiModelProperty(value = "拒收理由")
    private String biddingRefuseReason;
    @ApiModelProperty(value = "状态 0不正常 1正常")
    private Integer status;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;
}
