package com.epc.web.facade.bidding.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel("签到人员基本信息")
public class SignBaseDTO implements Serializable {
    private static final long serialVersionUID = 7027776455997362497L;
    @ApiModelProperty("公司ID")
    private  Long  supplierId;
    @ApiModelProperty("人员姓名")
    private  String name;
    @ApiModelProperty("手机号")
    private  String cellphone;
    @ApiModelProperty("公司名称")
    private  String companyName;

}
