package com.epc.administration.facade.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 17:45
 * <p>@Author : luozhixin
 * <p>userVO
 */
@Data
public class userVO implements Serializable {
    private static final long serialVersionUID = 1986626260794543811L;
    @ApiModelProperty("主键id")
    private  Long id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("创建时间")
    private Date crateTime;
    @ApiModelProperty("部门名称")
    private  String deptName;
}
