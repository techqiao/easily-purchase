package com.epc.web.client.controller.agency.handle;

import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "ClientHandleExpert",description = "新增专家的信息")
public class ClientHandleExpert implements Serializable {
    private static final long serialVersionUID = 3941607632108773688L;
    @ApiModelProperty(value = "专家姓名")
    @NotEmpty(message = "ClientHandleExpert.name.null")
    private String name;

    @ApiModelProperty(value = "专家电话")
    @NotEmpty(message = "ClientHandleExpert.cellphone.null")
    private String cellphone;

    @ApiModelProperty(value = "专家专业")
    private String profession;

    @ApiModelProperty(value = "专家职称")
    private String positional;

    @ApiModelProperty(value = "专家级别")
    private String level;

    @ApiModelProperty(value = "通知时间")
    private Date circularDt;

    @ApiModelProperty(value = "通知方式")
    private String circularMethod;

    @ApiModelProperty(value = "邀请人id")
    private Long inviterid;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邀请人公司的id")
    private String invterCompanyId;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "其他信息")
    private String otherInformation;
    @ApiModelProperty(value = "附件信息")
    private List<ClientAttachement> atts;



}
