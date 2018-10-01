package com.epc.administration.facade.reviewexpert.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 01
 */
@Data
public class ReviewExpertHandle implements Serializable {
    private static final long serialVersionUID = -2265620201281709989L;
    @ApiModelProperty(value = "专家id")
    private Long id;
    @ApiModelProperty(value = "评标专家姓名")
    private String name;
    @ApiModelProperty(value = "专业")
    private String profession;
    @ApiModelProperty(value = "职称")
    private String level;
    @ApiModelProperty(value = "通知时间")
    private Date circularDt;
    @ApiModelProperty(value = "通知方式")
    private String circularMethod;
    @ApiModelProperty(value = "其他信息")
    private String otherInformation;
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "统一信用代码")
    private String uniformCreditCode;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "对公银行名称")
    private String publicBankName;
    @ApiModelProperty(value = "对公银行账号")
    private String publicBanAccountNumber;

    @ApiModelProperty(value = "资质证书url")
    private List<AttachmentHandle> attachmentHandleList;




}
