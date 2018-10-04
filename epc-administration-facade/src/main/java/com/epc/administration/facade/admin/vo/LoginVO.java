package com.epc.administration.facade.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-01 21:47
 * <p>@Author : luozhixin
 * <p>LoginVO
 */
@Data
public class LoginVO implements Serializable {
    private static final long serialVersionUID = 5983107932163776483L;

    /**
     * 主键ID
     */
    @ApiModelProperty("用户主键id")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */

    private String password;

    /**
     * 部门id
     */
    @ApiModelProperty("部门id")
    private Long deptId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createAt;

}
