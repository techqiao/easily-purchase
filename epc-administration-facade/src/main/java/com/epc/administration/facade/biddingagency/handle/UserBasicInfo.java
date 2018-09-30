package com.epc.administration.facade.biddingagency.handle;


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
    private static final long serialVersionUID = -4987902122964018037L;
    private String cellphone;
    private String username;


}
