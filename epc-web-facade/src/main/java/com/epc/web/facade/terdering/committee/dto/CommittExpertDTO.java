package com.epc.web.facade.terdering.committee.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @Description: 专家信息
 * @Author: linzhixiang
 * @Date: 2018/10/12
 */

@Data
@ApiModel("专家信息")
public class CommittExpertDTO implements Serializable {
    private static final long serialVersionUID = -4086209308374462242L;
    @ApiModelProperty("专家姓名")
    private String name;
    @ApiModelProperty("专业")
    private String profession;
    @ApiModelProperty("级别")
    private String level;
    @ApiModelProperty("通知开始时间")
    private String circularDt;
    @ApiModelProperty("通知结束时间")
    private String circularDtEnd;
    @ApiModelProperty("通知方式")
    private String circularMethod;
}
