package com.epc.web.client.controller.bidding.query.notice;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @Description: 预告列表
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@ApiModel(value = "预告列表")
@Data
public class ClientAdvanceNoticeDTO extends PagerParam {
    @ApiModelProperty(value = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "预告标题")
    private String previewTitle;
    @ApiModelProperty(value = "预告内容")
    private String previewMemo;
}
