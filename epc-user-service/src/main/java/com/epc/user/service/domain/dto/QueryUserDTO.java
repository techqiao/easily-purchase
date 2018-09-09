package com.epc.user.service.domain.dto;

import com.epc.user.service.service.PagerParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-09 00:21
 * <p>@Author : wjq
 */
@ApiModel(value = "QueryUserDTO", description = "用户查询动态类")
public class QueryUserDTO extends PagerParam {
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public QueryUserDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
