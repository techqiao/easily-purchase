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

    @ApiModelProperty(value = "提问人ID")
    private Long questionerId;
    @ApiModelProperty("提问人姓名")
    private String questionerName;
    @ApiModelProperty("问题标题")
    private String title;
    @ApiModelProperty("问题内容")
    private String problem;
}
