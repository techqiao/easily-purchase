package com.epc.web.client.controller.bidding.query.notice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 预告详情
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel("预告详情")
public class ClientAdvanceNoticeDetailDTO {
    @ApiModelProperty(value = "详情id")
    private Long id;
    @ApiModelProperty(value = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "预告标题")
    private String previewTitle;
    @ApiModelProperty(value = "预告内容")
    private String previewMemo;
    @ApiModelProperty(value = "创建人")
    private String creator;
    @ApiModelProperty(value = "创建日期")
    private Date createAt;

}
