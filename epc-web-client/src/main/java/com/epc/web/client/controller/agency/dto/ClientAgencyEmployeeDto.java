package com.epc.web.client.controller.agency.dto;

import com.epc.common.constants.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
@ApiModel(value = "ClientAgencyEmployeeDto",description = "代理机构机构查询员工 姓名,电话,角色,注册时间,是够禁用删除")
@Data
public class ClientAgencyEmployeeDto implements Serializable {
    private static final long serialVersionUID = 8957807592477177019L;

    /**
     * 机构id
     */
    @ApiModelProperty(value = "代理机构id不为空")
    @NotEmpty(message = "ClientAgencyEmployeeDto.agencyId.null")
    private Long agencyId;
    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    private String name;
    /**
     * 员工手机
     */
    @ApiModelProperty(value = "手机")
    private String cellphone;
    /**
     * 员工状态
     */
    @ApiModelProperty(value = "员工状态是否审核")
    private Integer state;
    /**
     * 员工权限
     */
    @ApiModelProperty(value = "员工角色管理层或普通")
    private Integer role;
    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id")
    private Long employeeId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "注册时间")
    private Date createAt;
    /**
     * 禁用或启用
     */
    @ApiModelProperty(value = "启用或禁用")
    private Integer isForbbiden;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除状态")
    private Integer isDelete= Const.IS_DELETED.NOT_DELETED;
}
