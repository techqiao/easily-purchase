package com.epc.administration.facade.biddingagency.handle;


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
    private static final long serialVersionUID = -4987902122964018037L;
    private String cellphone;
    private String username;


}
