package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("中标提名记录")
public class TWinBidNominateVO implements Serializable {

    private static final long serialVersionUID = -6604815634815564422L;
    @ApiModelProperty("中标提名记录id")
    private Long id;

    @ApiModelProperty("采购人Id")
    private Long purchaserId;

    @ApiModelProperty("采购人姓名")
    private String purchaserName;

    @ApiModelProperty("经办人姓名")
    private String agencyName;

    @ApiModelProperty("经办人手机号")
    private String agencyPhone;

    @ApiModelProperty("是否全权给代理机构(0-否,1-是)")
    private Integer isPowerAgency;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目编码")
    private String projectCode;

    @ApiModelProperty("采购项目ID")
    private Long purchaseProjectId;

    @ApiModelProperty("采购项目名称")
    private String procurementProjectName;

    @ApiModelProperty("采购项目编码")
    private String procurementProjectCode;

    @ApiModelProperty("招标方式")
    private String purchaseMode;

    @ApiModelProperty("招标类型")
    private String purchaseType;

    @ApiModelProperty("招标内容")
    private String purchaseContent;

    @ApiModelProperty("标段编码")
    private String bidCode;

    @ApiModelProperty("第一中标人id")
    private Long firstSupplierid;

    @ApiModelProperty("第一中标人姓名")
    private String firstCompanyname;

    @ApiModelProperty("第一中标人金额")
    private BigDecimal firstPrice;

    @ApiModelProperty("第二中标人id")
    private Long twoSupplierid;

    @ApiModelProperty("第一中标人金额")
    private BigDecimal twoPrice;

    @ApiModelProperty("第二中标人姓名")
    private String twoCompanyname;

    @ApiModelProperty("第三中标人id")
    private Long threeSupplierid;

    @ApiModelProperty("第三中标人金额")
    private BigDecimal threePrice;

    @ApiModelProperty("第三中标人姓名")
    private String threeCompanyname;

    @ApiModelProperty("公示开始时间")
    private Date openStart;

    @ApiModelProperty("公示结束时间")
    private Date openEnd;

    @ApiModelProperty("中标公示附件")
    private String filePath;

}
