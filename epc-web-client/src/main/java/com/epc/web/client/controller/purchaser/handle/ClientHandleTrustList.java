package com.epc.web.client.controller.purchaser.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@ApiModel(value = "ClientHandleTrustList" ,description = "修改状态类,id必须,其他状态选择需要的即可")
public class ClientHandleTrustList implements Serializable{
    private static final long serialVersionUID = -4625866239143443443L;
    /**
     * 角色唯一id
     */
    @ApiModelProperty(value = "角色id")
    @NotEmpty(message = "ClientHandleTrustList.id.null")
    private Long id;
    /**
     * 黑白名单
     */
    @ApiModelProperty(value = "是否添加黑名单,白名单 white_list,黑名单 black_list")
    private String trustOrNot;
    /**
     * 启用或禁用
     */
    @ApiModelProperty(value = "是够禁用启用 0,禁用 1")
    private Integer  enableOrDisable;
    /**
     * 角色权限
     */
    @ApiModelProperty(value = "角色 法人 0 管理员1,员工 2")
    private Integer role;
    /**
     * 删除
     */
    @ApiModelProperty(value = "是否删除 不删除 0 删除 1")
    private Integer del;
}
