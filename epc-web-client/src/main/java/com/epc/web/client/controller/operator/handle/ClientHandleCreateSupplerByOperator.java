package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@ApiModel(value = "ClientHandleCreateSupplerByOperator", description = "运营商添加供应商")
@Data
public class ClientHandleCreateSupplerByOperator {

    @ApiModelProperty(value = "运营商员工主键id")
    @NotEmpty(message = "ClientHandleCreateSupplerByOperator.id.null")
    private Long id;

    @ApiModelProperty(value = "供应商法人姓名")
    private String name;

    @ApiModelProperty(value = "供应商手机号(登录账号)")
    @NotEmpty(message = "ClientHandleCreateSupplerByOperator.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "供应商姓名")
    private String supplierName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBanAccountNumber;

    @ApiModelProperty(value = "来源(public,private)")
    private String source;

    @ApiModelProperty(value = "供应商的公司名字")
    private String companyName;


}
