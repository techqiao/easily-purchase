package com.epc.administration.facade.reviewexpert.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 16:25
 * <p>@Author : luozhixin
 * <p>ExpertDetailVO
 */
@Data
public class ExpertDetailVO implements Serializable {
    private static final long serialVersionUID = -9131242983455852528L;
    @ApiModelProperty("主鍵id")
    private Long id;
    @ApiModelProperty("评标专家姓名")
    private String name;
    @ApiModelProperty("手机号(登录账号)")
    private String cellphone;
    @ApiModelProperty("专业")
    private String profession;
    @ApiModelProperty("职称")
    private String  positional;
    @ApiModelProperty("级别")
    private String level;
    @ApiModelProperty("0-繁忙, 1-空闲")
    private Integer isIdle;
    @ApiModelProperty("从业年限")
    private Integer workingYears;
    @ApiModelProperty("通知时间")
    private Date circularDt;
    @ApiModelProperty(value = "身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty("通知方式")
    private String circularMethod;
    @ApiModelProperty("其他信息")
    private String otherInformation;
    @ApiModelProperty("0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败")
    private Integer state;
    @ApiModelProperty("创建时间")
    private Date createAt;
    @ApiModelProperty("公司名称")
    private String companyName;
    @ApiModelProperty("公司地址")
    private String companyAddress;
    @ApiModelProperty("附件集合")
    private List<AttachmentVO> attachmentVOList;
}
