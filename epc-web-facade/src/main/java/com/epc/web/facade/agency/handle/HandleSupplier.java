package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "HandleSupplier",description = "新增供货商的信息")
public class HandleSupplier {
    @ApiModelProperty(value = "供货商姓名")
    @NotEmpty(message = "HandleSupplier.name.null")
    private String name;

    @ApiModelProperty(value = "供货商电话")
    @NotEmpty(message = "HandleSupplier.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "供货商密码")
    private String password;

    @ApiModelProperty(value = "操作人id")
    private String agencyId;

    @ApiModelProperty(value = "供货商来源")
    private String source;

    @ApiModelProperty(value = "邀请类型")
    private Integer inviterType;

    @ApiModelProperty(value = "供货商公司名")
    private String companyName;

    @ApiModelProperty(value = "供货商信用证号")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBanAccountNumber;
}
