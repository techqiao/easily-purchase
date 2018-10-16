package com.epc.web.facade.supplier.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("参与的采购项目列表")
public class TenderMessageVO implements Serializable {
    private static final long serialVersionUID = -1517806962839524224L;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("项目编码")
    private String projectCode;
    @ApiModelProperty("采购项目id")
    private Long purchaseProjectId;
    @ApiModelProperty("标段Id")
    private String bidId;
    @ApiModelProperty("标段名称")
    private String bidName;
    @ApiModelProperty("投标进度")
    private String Schedule;
    @ApiModelProperty("投标状态")
    private String status;
    @ApiModelProperty("招标类型")
    private String projectType;
}
