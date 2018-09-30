package com.epc.web.facade.bidding.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 查看保证金返还
 * @Author: linzhixiang
 * @Date: 2018/9/28
 */ 
@Data
@Api(value ="查看保证金返还" )
public class IsBackTenderMoneyRecordVO implements Serializable {
    private static final long serialVersionUID = -966103363414203576L;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "标段名称")
    private String bidsName;

    @ApiModelProperty(value = "标段编号")
    private String bidsCode;

    @ApiModelProperty(value = "是否返还")
    private Boolean isBack;
}
