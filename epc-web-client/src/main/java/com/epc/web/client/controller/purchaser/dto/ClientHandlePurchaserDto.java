package com.epc.web.client.controller.purchaser.dto;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ClientHandlePurchaserDto",description = "员工信息修改可以一个也可以多个")
public class ClientHandlePurchaserDto implements Serializable {
    private static final long serialVersionUID = -3612745456221831087L;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String name;
    /**
     *手机号
     */
    @ApiModelProperty(value = "用户手机")
    private String cellphone;
    /**
     * 用户角色
     */
    @ApiModelProperty(value = "用户角色")
    private Integer role;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "跟新时间")
    private Date updateAt;
}
