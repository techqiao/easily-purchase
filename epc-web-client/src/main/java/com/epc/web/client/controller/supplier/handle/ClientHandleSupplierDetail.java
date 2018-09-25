package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


/**
 * 供应商注册详情
 */

@Data
@ApiModel(value = "ClientHandleSupplierDetail", description = "供应商信息")
public class ClientHandleSupplierDetail {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "供应商注册id")
    private Long supplierId;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;

    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;

    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;

    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;

    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    private String operatorIdCardFront;

    @ApiModelProperty(value = "资质证书url")
    private String qualificationCertificate;

    @ApiModelProperty(value = "所在地区")
    private String[] location;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行账号")
    private String publicBankCount;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientHandleSupplierDetail.cellPhone.null")
    private String cellphone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "ClientHandleSupplierDetail.password.null")
    private String password;


}
