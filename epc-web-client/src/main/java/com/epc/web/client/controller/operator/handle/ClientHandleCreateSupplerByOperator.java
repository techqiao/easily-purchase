package com.epc.web.client.controller.operator.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@ApiModel(value = "ClientHandleCreateSupplerByOperator", description = "运营商添加供应商")
@Data
public class ClientHandleCreateSupplerByOperator {

    @ApiModelProperty(value = "主键id")
    @NotEmpty(message = "ClientHandleCreateSupplerByOperator.id.null")
    private Long id;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "手机号(登录账号)")
    @NotEmpty(message = "ClientHandleCreateSupplerByOperator.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败")
    private Integer state;

    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;

    @ApiModelProperty(value = "供应商姓名")
    @NotEmpty(message = "ClientHandleCreateSupplerByOperator.supplierName.null")
    private String supplierName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBanAccountNumber;

    @ApiModelProperty(value = "来源(public,private)")
    private String source;

    @ApiModelProperty(value = "操作人ID")
    private String operatorId;

    @ApiModelProperty(value = "创建时间")
    @NotEmpty(message = "ClientHandleCreateSupplerByOperator.id.null")
    private Date createAt;

    @ApiModelProperty(value = "最后修改时间")
    private Date updateAt;

    @ApiModelProperty(value = "是否删除: 0-存在,1-删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "供应商的公司名字")
    private String companyName;


}
