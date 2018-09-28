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
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientRoleDetailInfo", description = "运营商完善信息")
public class ClientRoleDetailInfo implements Serializable {

    private static final long serialVersionUID = 1357220411904844711L;
    @ApiModelProperty(value = "角色")
    @NotEmpty(message = "ClientRoleDetailInfo.systemRole.null")
    private String systemRole;
    @ApiModelProperty(value = "注册人Id")
    @NotEmpty(message = "ClientRoleDetailInfo.userId.null")
    private Long userId;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientRoleDetailInfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientRoleDetailInfo.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientRoleDetailInfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "ClientRoleDetailInfo.qualificationCertificate.null")
    private List<String> qualificationCertificateList;
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "ClientRoleDetailInfo.businessLicense.null")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientRoleDetailInfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientRoleDetailInfo.legalIdCardOther.null")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    @NotEmpty(message = "ClientRoleDetailInfo.certificateOfAuthorization.null")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    @NotEmpty(message = "ClientRoleDetailInfo.operatorIdCardFront.null")
    private String operatorIdCardFront;


}
