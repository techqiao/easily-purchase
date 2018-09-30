package com.epc.administration.client.controller.admin.dto;

import com.epc.common.QueryRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 20:56
 * <p>@Author : luozhixin
 * <p>ClientQueryUserDTO
 */
@Data
public class ClientQueryUserDTO extends QueryRequest implements Serializable {
    private static final long serialVersionUID = 5634176199862878833L;

    @ApiModelProperty(value = "用户名" ,notes = "用户名")
    private String userName;
    @ApiModelProperty(value = "手机号",notes = "手机号")
    private String phone;
    @ApiModelProperty(value = "部门id",notes = "部门id")
    private Long deptId;
}
