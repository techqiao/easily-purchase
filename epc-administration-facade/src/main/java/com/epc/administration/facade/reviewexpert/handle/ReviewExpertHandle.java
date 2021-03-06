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
    @ApiModelProperty(value = "手机号")
    private String cellPhone;
    @ApiModelProperty(value = "专业")
    private String profession;
    @ApiModelProperty(value = "职称")
    private String positional;
    @ApiModelProperty(value = "级别")
    private String level;
    @ApiModelProperty(value = "从业年限")
    private Integer workingYears;
    @ApiModelProperty(value = "通知时间")
    private Date circularDt;
    @ApiModelProperty(value = "通知结束时间")
    private Date circularDtEnd;
    @ApiModelProperty(value = "通知方式")
    private String circularMethod;
    @ApiModelProperty(value = "其他信息")
    private String otherInformation;
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "公司地址")
    private String companyAddress;
    /**
     * 省份
     */
    private String province;
    /**
     * 市区
     */
    private String city;
    /**
     * 区域
     */
    private String area;
    @ApiModelProperty(value = "资质证书url")
    private List<AttachmentHandle> attachmentHandleList;




}
