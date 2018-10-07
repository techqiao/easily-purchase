package com.epc.web.client.controller.purchaser.dto;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@ApiModel(value = "ClientHandleExpertDto",description = "采购人完善专家或者查询专家信息")
public class ClientHandleExpertDto implements Serializable {
    private static final long serialVersionUID = -148655324199546314L;
    /**
     *专家姓名
     */
    @ApiModelProperty(value = "专家姓名")
    private String expertName;
    /**
     * 专家Id
     *
     */
    @ApiModelProperty(value = "专家id")
    private Long expertId;
    /**
     * 庄家专业
     */
    @ApiModelProperty(value = "专家专业")
    private String profession;
    /**
     * 庄家职称
     */
    @ApiModelProperty(value = "专家职称")
    private String  positional;

    /**
     * 专家水平
     */
    @ApiModelProperty(value = "专家水平")
    private String level;
    /**
     * 采购人id
     */
    @ApiModelProperty(value = "采购人id")
    @NotEmpty(message="ClientHandleExpertDto.puchaserId.null")
    private Long puchaserId;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    private String cellphone;

    /**
     * 通知时间
     */
    @ApiModelProperty(value = "通知时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date circularDt;
    /**
     * 通知方式
     */
    @ApiModelProperty(value = "通知方式")
    private String circularMethod;
    /**
     * 其他信息
     */
    @ApiModelProperty(value = "其他信息")
    private String otherInformation;
    /**
     * 邀请人类型
     */
    @ApiModelProperty(value = "邀请人类型")
    private Integer inviterType;
    /**
     * 邀请人Id
     */
    @ApiModelProperty(value = "邀请人id")
    private Long inviterId;
    /**
     * inviter_company_id
     * 邀请人机构ID
     */
    @ApiModelProperty(value = "邀请人机构id")
    private Long inviterCompanyId;
    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    private Integer state;
    /**
     * 专家附件
     */

    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "专家附件 如身份证等")
    private List<ClientAttachement> atts;
}
