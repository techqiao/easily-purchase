package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 预告详情
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel("预告详情")
public class AdvanceNoticeDetailVO implements Serializable {
    private static final long serialVersionUID = 4845592757642891386L;
    @ApiModelProperty("预告id")
    private Long id;

    @ApiModelProperty("项目编码")
    private String projectCode;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目Id")
    private Long projectId;

    @ApiModelProperty("预告标题")
    private String previewTitle;

    @ApiModelProperty("预告内容")
    private String previewMemo;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private String createAt;

}
