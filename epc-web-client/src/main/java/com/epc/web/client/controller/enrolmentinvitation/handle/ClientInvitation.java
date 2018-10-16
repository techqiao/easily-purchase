package com.epc.web.client.controller.enrolmentinvitation.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @Description: 确认/拒绝 邀请
 * @Author: linzhixiang
 * @Date: 2018/10/15
 */ 
@Data
@ApiModel("确认/拒绝")
public class ClientInvitation implements Serializable {
    private static final long serialVersionUID = 6695763333610572421L;
    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("状态（true:确认，false:拒绝）")
    private Boolean status;
    @ApiModelProperty("0-公告 1-私有")
    private Integer signUpType;
}
