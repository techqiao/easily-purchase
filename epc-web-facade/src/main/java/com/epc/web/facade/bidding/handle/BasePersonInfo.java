package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "人员基本信息")
public class BasePersonInfo {
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "姓名")
    private String name;
}
