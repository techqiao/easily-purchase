package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("监管项目列表")
public class listMonitorVO implements Serializable {

    private static final long serialVersionUID = -7424820334281892255L;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("采购项目id")
    private Long purchaseProjectId;
    @ApiModelProperty("采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty("采购项目开始时间")
    private Date purchaseStartTime;
    @ApiModelProperty("采购项目结束时间")
    private Date purchaseEndTime;
    @ApiModelProperty("采购方式")
    private String purchaseMode;
    @ApiModelProperty("采购状态")
    private Integer isEnd;

}
