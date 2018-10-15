package com.epc.web.facade.terdering.bid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-15 11:31
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "唱标")
public class LetterTenderVO {
    @ApiModelProperty(value = "投标函ID")
    private Long id;
    @ApiModelProperty(value = "采购项目ID")
    private String procurementProjectId;
    @ApiModelProperty(value = "供货商id")
    private Long supplierId;
    @ApiModelProperty(value = "供货商名称")
    private Long supplierName;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "标段名称")
    private String bidsName;
    @ApiModelProperty(value = "投标总金额")
    private BigDecimal money;
    @ApiModelProperty(value = "工程质量目标")
    private String qualityTarget;
    @ApiModelProperty(value = "工期")
    private Integer duration;
    @ApiModelProperty(value = "投标有效期")
    private Integer validity;
    @ApiModelProperty(value = "项目经理姓名")
    private String managerName;
    @ApiModelProperty(value = "执业证书号码")
    private String certificateNumber;
}
