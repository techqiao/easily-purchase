package com.epc.web.client.controller.bidding.handle.sign;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "人员基本信息")
public class ClientPersonInfo {
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
}
