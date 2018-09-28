package com.epc.administration.client.controller.operator.dto;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzx
 * @date
 */
@ApiModel
@Data
public class ClientQueryDetailIfo  extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 6637761805863799048L;
    @ApiModelProperty(value = "公司名称")
    private String where;
    @ApiModelProperty(value = "状态：0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败")
    private Integer status;

}
