package com.epc.web.client.controller.agency.dto;

import com.epc.web.client.controller.agency.handle.ClientAttachement;
import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@ApiModel(value = "ClientAgencyExpertDto" ,description = "代理机构专家信息查询条件")
public class ClientAgencyExpertDto implements Serializable {
    private static final long serialVersionUID = 7424211851644334604L;
    /**
     *专家姓名
     */
    @ApiModelProperty(value = "专家名字")
    private String expertName;
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
     * 代理机构id
     */
    @ApiModelProperty(value = "代理机构id")
    private Long agencyId;

    /**
     * 手机
     */
    @ApiModelProperty(value = "专家手机")
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
    @ApiModelProperty(value = "附件信息,身份证,证书等")
    private List<ClientAttachement> atts;

}
