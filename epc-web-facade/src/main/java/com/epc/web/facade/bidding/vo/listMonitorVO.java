package com.epc.web.facade.bidding.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@ApiModel("监管项目列表")
public class listMonitorVO implements Serializable {
    private static final long serialVersionUID = -7424820334281892255L;
    @ApiModelProperty("项目编码")
    private String projectCode;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("采购项目id")
    private Long purchaseProjectId;
    @ApiModelProperty("采购项目名称")
    private String purchaseProjectName;
    @ApiModelProperty("采购项目开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String purchaseStartTime;
    @ApiModelProperty("采购项目结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String purchaseEndTime;
    @ApiModelProperty("采购方式")
    private String purchaseMode;
    @ApiModelProperty("采购状态(0:进行中，1：结束)")
    private Integer isEnd;

}
