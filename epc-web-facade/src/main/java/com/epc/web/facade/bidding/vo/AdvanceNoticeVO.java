package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("预告列表")
public class AdvanceNoticeVO implements Serializable {

    private static final long serialVersionUID = -3082577098940275834L;
    @ApiModelProperty("预告Id")
    private Long id;
    @ApiModelProperty("项目编码")
    private String projectCode;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("项目标题")
    private String previewTitle;

}
