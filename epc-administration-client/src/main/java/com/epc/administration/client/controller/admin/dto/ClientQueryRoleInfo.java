package com.epc.administration.client.controller.admin.dto;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 01
 * @date  2018-9-19 15:59:54
 */
@ApiModel
@Data
public class ClientQueryRoleInfo extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 4260891879711559835L;
    @ApiModelProperty(value = "角色名")
    private String name;

}
