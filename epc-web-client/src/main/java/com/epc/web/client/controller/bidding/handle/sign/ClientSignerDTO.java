package com.epc.web.client.controller.bidding.handle.sign;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linzhixiang
 */
@Data
@ApiModel(value = "供应商签到")
public class ClientSignerDTO {
    @ApiModelProperty(value = "标段ID")
    private Long bidId;
    @ApiModelProperty(value = "签到人姓名")
    private String name;
    @ApiModelProperty(value = "电话号码")
    private String cellPhone;
    @ApiModelProperty(value = "身份证")
    private String idCard;
}
