package com.epc.web.client.controller.terdering.bid.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 11:41
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientHandleExpertScore",description = "专家评分")
public class ClientHandleExpertScore {
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "标段编号")
    private Long bidsCode;
    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "供应商(法人)ID")
    private Long supplierId;
    @ApiModelProperty(value = "供应商公司名称")
    private String supplierCompanyName;
    @ApiModelProperty(value = "技术评标分数")
    private Integer techTypeScore;
    @ApiModelProperty(value = "商务评标分数")
    private Integer commerceTypeScore;
    @ApiModelProperty(value = "最终评标分数")
    private Integer finalScore;
    @ApiModelProperty(value = "专家ID")
    private Long expertId;
    @ApiModelProperty(value = "专家姓名")
    private String expertName;
    @ApiModelProperty(value = "操作人ID")
    private Long operateId;

}
