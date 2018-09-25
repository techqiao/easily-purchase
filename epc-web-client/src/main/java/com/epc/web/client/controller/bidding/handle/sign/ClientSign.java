package com.epc.web.client.controller.bidding.handle.sign;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "供应商签到",description = "扫一扫输入手机号，姓名签到")
public class ClientSign  extends ClientPersonInfo {

    @ApiModelProperty(value = "采购项目ID")
    private Long procurementProjectId;
    @ApiModelProperty(value = "标段ID")
    private Long bidsId;
    @ApiModelProperty(value = "标段名称")
    private String bidsName;

}
