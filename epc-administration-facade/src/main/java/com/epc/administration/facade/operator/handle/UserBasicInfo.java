package com.epc.administration.facade.operator.handle;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;


/**
 * <p>Description : 注册用户
 * <p>Date : 2018-09-10  18:14
 * <p>@author : wjq
 */
@Data
@ApiModel(value = "UserBasicInfo", description = "注册运营商")
public class UserBasicInfo implements Serializable {
    private static final long serialVersionUID = 2062584142645359465L;
    private String cellphone;
    private String username;

}
