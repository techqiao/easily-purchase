package com.epc.web.facade.terdering.answer.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-10-03 17:04
 * <p>@Author : wjq
 */
@Data
public class PublicitySubVO {
    @ApiModelProperty(value = "问题")
    private String problem;
    @ApiModelProperty(value = "答案")
    private String answer;
    @ApiModelProperty(value = "发布时间")
    private Date startTime;
}
