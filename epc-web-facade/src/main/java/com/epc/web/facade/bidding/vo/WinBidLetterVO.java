package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linzhixiang
 */
@Data
@ApiModel("中标通知书")
public class WinBidLetterVO implements Serializable {
    private static final long serialVersionUID = -5475351066938868221L;
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目编码")
    private String projectCode;

    @ApiModelProperty("采购项目名称")
    private String procurementProjectName;

    @ApiModelProperty("标段名称")
    private String bidName;

    @ApiModelProperty("标段编码")
    private String bidCode;

    @ApiModelProperty("文件路径")
    private String filePath;

}
