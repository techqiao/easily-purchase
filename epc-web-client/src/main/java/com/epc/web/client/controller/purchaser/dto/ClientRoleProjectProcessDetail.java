package com.epc.web.client.controller.purchaser.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientRoleProjectProcessDetail", description = "角色登录查看项目详情")
public class ClientRoleProjectProcessDetail implements Serializable {
    private static final long serialVersionUID = -7588187928951672589L;
    @ApiModelProperty(value = "角色id")
    @NotEmpty(message = "ClientRoleProjectProcessDetail.id.null")
    private Long id;
    @ApiModelProperty(value = "用户角色代理机构2,采购人4")
    @NotEmpty(message = "ClientRoleProjectProcessDetail.userType.null")
    private Integer userType;
    @ApiModelProperty(value = "中标公示(publicity)或公告(announcement)")
    @NotEmpty(message = "ClientRoleProjectProcessDetail.stepType.null")
    private String stepType;
    @ApiModelProperty(value = "显示数据大小,默认大小10")
    private Integer pageSize;
    @ApiModelProperty(value = "角色id,默认第一页")
    private Integer pageNum;
}
