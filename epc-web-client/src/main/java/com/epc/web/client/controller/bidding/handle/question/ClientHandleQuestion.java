package com.epc.web.client.controller.bidding.handle.question;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "新增问题记录",description = "新增问题记录")
public class ClientHandleQuestion {

    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty("问题类别(公告-announcement,招标文件-bidFile,评标-bidEvaluation)")
    private String questionType;
    @ApiModelProperty("问题标题")
    private String title;
    @ApiModelProperty("问题内容")
    private String problem;
}
