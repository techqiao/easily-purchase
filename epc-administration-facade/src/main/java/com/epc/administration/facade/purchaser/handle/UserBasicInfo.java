package com.epc.administration.facade.purchaser.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


/**
 * <p>Description : 注册用户
 * <p>Date : 2018-09-10  18:14
 * <p>@author : wjq
 */
@Data
@ApiModel(value = "UserBasicInfo", description = "注册运营商")
public class UserBasicInfo implements Serializable {
    private static final long serialVersionUID = -3430729044791432992L;
    @ApiModelProperty(value = "电话号")
    @NotEmpty(message = "UserBasicInfo.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "电话号")
    @NotEmpty(message = "UserBasicInfo.username.null")
    private String username;

}
