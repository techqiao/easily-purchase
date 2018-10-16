package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:02
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "投标人信息")
public class BidderVO {
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;
    @ApiModelProperty(value = "供应商公司名称")
    private String supplierCompanyName;
    @ApiModelProperty(value = "状态 待评分wait 已评分already")
    private String status;
}
