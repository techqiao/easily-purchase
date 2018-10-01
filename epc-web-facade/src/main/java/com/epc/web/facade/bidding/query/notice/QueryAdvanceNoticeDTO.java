package com.epc.web.facade.bidding.query.notice;

import com.epc.common.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryAdvanceNoticeDTO extends PagerParam implements Serializable {

    @ApiModelProperty(value = "项目编码")
    private String projectCode;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "预告标题")
    private String previewTitle;
    @ApiModelProperty(value = "预告内容")
    private String previewMemo;
}
