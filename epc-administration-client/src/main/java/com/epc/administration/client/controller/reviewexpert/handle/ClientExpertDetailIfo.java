package com.epc.administration.client.controller.reviewexpert.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@Data
@ApiModel(value = "ClientExpertDetailIfo", description = "运营商完善信息")
public class ClientExpertDetailIfo implements Serializable {
    private static final long serialVersionUID = -5360305138253790916L;
    @ApiModelProperty(value = "专家id")
    @NotEmpty(message = "ClientExpertDetailIfo.id.null")
    private Long id;
    @ApiModelProperty(value = "评标专家姓名")
    @NotEmpty(message = "ClientExpertDetailIfo.name.null")
    private String name;
    @ApiModelProperty(value = "专业")
    @NotEmpty(message = "ClientExpertDetailIfo.profession.null")
    private String profession;
    @ApiModelProperty(value = "职称")
    @NotEmpty(message = "ClientExpertDetailIfo.level.null")
    private String level;
    @ApiModelProperty(value = "通知时间")
    @NotEmpty(message = "ClientExpertDetailIfo.circularDt.null")
    private Date circularDt;
    @ApiModelProperty(value = "通知方式")
    @NotEmpty(message = "ClientExpertDetailIfo.circularMethod.null")
    private String circularMethod;
    @ApiModelProperty(value = "其他信息")
    @NotEmpty(message = "ClientExpertDetailIfo.otherInformation.null")
    private String otherInformation;
    @ApiModelProperty(value = "法人身份证正面照片url")
    @NotEmpty(message = "ClientExpertDetailIfo.legalIdCardPositive.null")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    @NotEmpty(message = "ClientExpertDetailIfo.legalIdCardOther.null")
    private String legalIdCardOther;
    @ApiModelProperty(value = "统一信用代码")
    @NotEmpty(message = "ClientExpertDetailIfo.uniformCreditCode.null")
    private String uniformCreditCode;
    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientExpertDetailIfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    @NotEmpty(message = "ClientExpertDetailIfo.publicBankName.null")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    @NotEmpty(message = "ClientExpertDetailIfo.publicBanAccountNumber.null")
    private String publicBanAccountNumber;

    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "ClientExpertDetailIfo.qualificationCertificateList.null")
    private List<ClientAttachmentHandle> attachmentHandleList;

}
