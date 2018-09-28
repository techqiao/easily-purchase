package com.epc.administration.client.controller.reviewexpert.handle;


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
public class ClientUserBasicInfo implements Serializable {
    private static final long serialVersionUID = -806841689189479148L;
    @ApiModelProperty(value = "电话号")
    @NotEmpty(message = "ClientUserBasicInfo.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "ClientUserBasicInfo.username.null")
    private String username;
}
