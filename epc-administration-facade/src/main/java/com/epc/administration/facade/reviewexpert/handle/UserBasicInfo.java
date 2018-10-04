package com.epc.administration.facade.reviewexpert.handle;


import com.epc.administration.facade.admin.handle.LoginHandle;
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
public class UserBasicInfo extends LoginHandle implements Serializable {
    private static final long serialVersionUID = 2359128958999832699L;
    /**
     * 用户手机号
     */
    private String cellphone;
    /**
     * 用户名
     */
    private String username;


}
