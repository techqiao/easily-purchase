package com.epc.administration.client.controller.operator.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : luozhixin
 */
@Data
@ApiModel(value = "ClientOperatorDetailInfo", description = "运营商完善信息")
public class ClientOperatorDetailInfo implements Serializable {

    private static final long serialVersionUID = 1357220411904844711L;

    @ApiModelProperty(value = "注册人Id")
    @NotEmpty(message = "ClientOperatorDetailInfo.id.null")
    private Long id;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientOperatorDetailInfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "公司地址")
    @NotEmpty(message = "ClientOperatorDetailInfo.companyAddress.null")
    private String companyAddress;
    @ApiModelProperty(value = "省份")
    @NotEmpty(message = "ClientOperatorDetailInfo.province.null")
    private String province;
    @ApiModelProperty(value = "市区")
    @NotEmpty(message = "ClientOperatorDetailInfo.city.null")
    private String city;
    @ApiModelProperty(value = "区域")
    @NotEmpty(message = "ClientOperatorDetailInfo.area.null")
    private String area;
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientOperatorDetailInfo.cellphone.null")
    private String cellphone;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientOperatorDetailInfo.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientOperatorDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "ClientOperatorDetailInfo.businessLicense.null")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientOperatorDetailInfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientOperatorDetailInfo.legalIdCardOther.null")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    @NotEmpty(message = "ClientOperatorDetailInfo.certificateOfAuthorization.null")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "ClientOperatorDetailInfo.uniformCreditCode.null")
    private String uniformCreditCode;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "ClientOperatorDetailInfo.qualificationCertificate.null")
    private List<ClientOperatorAttachmentHandle> qualificationCertificateList;

}
