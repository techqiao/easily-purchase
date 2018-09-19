package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "HandleSupplierDetail", description = "供应商人员信息")
public class ClientHandleSupplierDetail {
    @ApiModelProperty(value = "供应商Id")
    @NotEmpty(message = "HandlePurchaser.userId.null")
    private long userId;
    @ApiModelProperty(value = "供应商名称")
    @NotEmpty(message = "HandlePurchaser.name.null")
    private String name;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "HandlePurchaser.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "统一信用代码")
    @NotEmpty(message = "HandlePurchaser.uniformCreditCode.null")
    private String uniformCreditCode;
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "HandlePurchaser.businessLicense.null")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "HandlePurchaser.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "HandlePurchaser.legalIdCardOther.null")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    @NotEmpty(message = "HandlePurchaser.certificateOfAuthorization.null")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    @NotEmpty(message = "HandlePurchaser.operatorIdCardFront.null")
    private String operatorIdCardFront;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "HandlePurchaser.qualificationCertificate.null")
    private String qualificationCertificate;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "HandlePurchaser.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "HandlePurchaser.publicBankCount.null")
    private String publicBankCount;
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "HandlePurchaser.cellPhone.null")
    private String cellPhone;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "HandlePurchaser.password.null")
    private String password;
    @ApiModelProperty(value = "操作人Id")
    @NotEmpty(message = "HandlePurchaser.OperatorId.null")
    private long OperatorId;
}
