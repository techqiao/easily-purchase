package com.epc.mobile.client.controller.terdering.project.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientQueryPurchaserEmployeeIdAndRole",description = "对创建这个项目的人一个回馈，是否接受")
@Data
public class ClientQueryPurchaserEmployeeIdAndRole {

    @ApiModelProperty(value = "当前登陆人的id")
    private Long id;

//    @ApiModelProperty(value = "当前 人必须 是采购人下的员工")
//    private int purchaser;

    @ApiModelProperty(value = "当前登陆人的角色")
    private Integer role;


}
