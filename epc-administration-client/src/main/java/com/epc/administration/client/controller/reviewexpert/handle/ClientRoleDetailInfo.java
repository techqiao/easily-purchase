package com.epc.administration.client.controller.reviewexpert.handle;


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
    private static final long serialVersionUID = -1891560130795083423L;
    @ApiModelProperty(value = "角色")
    @NotEmpty(message = "ClientRoleDetailIfo.systemRole.null")
    private String systemRole;
    @ApiModelProperty(value = "注册人Id")
    @NotEmpty(message = "ClientRoleDetailIfo.userId.null")
    private Long userId;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientRoleDetailIfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientRoleDetailIfo.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientRoleDetailIfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "ClientRoleDetailIfo.qualificationCertificate.null")
    private List<String> qualificationCertificateList;
    @ApiModelProperty(value = "营业执照照片url")
    @NotEmpty(message = "ClientRoleDetailIfo.businessLicense.null")
    private String businessLicense;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientRoleDetailIfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientRoleDetailIfo.legalIdCardOther.null")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    @NotEmpty(message = "ClientRoleDetailIfo.certificateOfAuthorization.null")
    private String certificateOfAuthorization;
    @ApiModelProperty(value = "经办人(运营商员工)手持身份证正面照片url")
    @NotEmpty(message = "ClientRoleDetailIfo.operatorIdCardFront.null")
    private String operatorIdCardFront;


}
