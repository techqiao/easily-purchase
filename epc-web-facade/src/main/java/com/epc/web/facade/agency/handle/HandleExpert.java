package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "HandleExpert",description = "新增专家的信息")
public class HandleExpert implements Serializable {
    @ApiModelProperty(value = "专家姓名")
    @NotEmpty(message = "HandleExpert.name.null")
    private String name;

    @ApiModelProperty(value = "专家电话")
    @NotEmpty(message = "HandleExpert.cellphone.null")
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

    @ApiModelProperty(value = "邀请方式")
    private Integer invitertype;

    @ApiModelProperty(value = "邀请人id")
    private Long inviterid;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邀请人公司的id")
    private String invterCompanyId;

    @ApiModelProperty(value = "来源")
    private String source;




}
