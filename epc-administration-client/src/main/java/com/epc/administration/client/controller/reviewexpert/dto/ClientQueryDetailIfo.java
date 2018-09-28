package com.epc.administration.client.controller.reviewexpert.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzx
 * @date 2018-9-19 17:10:25
 */
@Data
@ApiModel
public class ClientQueryDetailIfo implements Serializable {
    private static final long serialVersionUID = 8499642062806503052L;
    @ApiModelProperty(value = "公司名称")
    private String where;
    @ApiModelProperty(value = "状态：0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败")
    private Integer status;

}
