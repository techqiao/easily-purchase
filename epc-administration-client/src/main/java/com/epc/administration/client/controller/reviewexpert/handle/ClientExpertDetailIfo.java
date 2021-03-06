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
    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "ClientExpertDetailIfo.cellPhone.null")
    private String cellPhone;
    @ApiModelProperty(value = "专业")
    @NotEmpty(message = "ClientExpertDetailIfo.profession.null")
    private String profession;
    @ApiModelProperty(value = "职称")
    @NotEmpty(message = "ClientExpertDetailIfo.positional.null")
    private String positional;
    @ApiModelProperty(value = "级别")
    @NotEmpty(message = "ClientExpertDetailIfo.level.null")
    private String level;
    @ApiModelProperty(value = "从业年限")
    @NotEmpty(message = "ClientExpertDetailIfo.workingYears.null")
    private Integer workingYears;
    @ApiModelProperty(value = "通知时间")
    @NotEmpty(message = "ClientExpertDetailIfo.circularDt.null")
    private Date circularDt;
    @ApiModelProperty(value = "通知结束时间")
    @NotEmpty(message = "ClientExpertDetailIfo.circularDtEnd.null")
    private Date circularDtEnd;
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

    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "ClientExpertDetailIfo.companyName.null")
    private String companyName;
    @ApiModelProperty(value = "公司地址")
    @NotEmpty(message = "ClientExpertDetailIfo.companyAddress.null")
    private String companyAddress;
    @ApiModelProperty(value = "省份")
    @NotEmpty(message = "ClientExpertDetailIfo.province.null")
    private String province;
    @ApiModelProperty(value = "市区")
    @NotEmpty(message = "ClientExpertDetailIfo.city.null")
    private String city;
    @ApiModelProperty(value = "区域")
    @NotEmpty(message = "ClientExpertDetailIfo.area.null")
    private String area;
    @ApiModelProperty(value = "资质证书url")
    @NotEmpty(message = "ClientExpertDetailIfo.qualificationCertificateList.null")
    private List<ClientAttachmentHandle> attachmentHandleList;

}
