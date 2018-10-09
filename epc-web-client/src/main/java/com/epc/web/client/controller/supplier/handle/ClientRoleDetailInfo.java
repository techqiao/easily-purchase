package com.epc.web.client.controller.supplier.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientRoleDetailInfo",description = "角色完善资料")
public class ClientRoleDetailInfo {



//    @ApiModelProperty(value = "角色类型")
//    private Integer type;

    @ApiModelProperty(value = "员工id")
    private Long supplierId;

    @ApiModelProperty(value = "法人姓名")
    private String name;

    @ApiModelProperty(value = "公司名字")
    private String companyName;

    @ApiModelProperty(value = "公司地址")
    private String companyAddress;

    @ApiModelProperty(value = "信用号码")
    private String uniformCreditCode;

    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;

    @ApiModelProperty(value = "对公银行号码")
    private String publicBanAccountNumber;


    @ApiModelProperty(value = "营业执照照片url")
    private String businessLicense;
    @ApiModelProperty(value = "营业执照号码")
    private String businessLicenseNumber;

    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证正面照片号码")
    private String legalIdCardPositiveNumber;

    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;

    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "带公章的授权书号码")
    private String certificateOfAuthorizationNumber;

    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    private String operatorIdCardFront;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片号码")
    private String operatorIdCardFrontNumber;


//    @ApiModelProperty(value = "全部附件")
//    private List<ClientAttachment> atts;

//    @ApiModelProperty(value = "资质证书url")
//    private String qualificationCertificate;
//    @ApiModelProperty(value = "资质证书号码")
//    private String qualificationCertificateNumber;

    @ApiModelProperty(value = "资质证书s")
    private List<ClientQualificationCertificate> qcs;
}
