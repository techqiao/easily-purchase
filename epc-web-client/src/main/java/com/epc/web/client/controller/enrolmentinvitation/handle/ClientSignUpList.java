package com.epc.web.client.controller.enrolmentinvitation.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @Description: 报名列表
 * @Author: linzhixiang
 * @Date: 2018/10/11
 */ 
@Data
@ApiModel("报名列表")
public class ClientSignUpList implements Serializable {
    private static final long serialVersionUID = -2028261383242767468L;
    @ApiModelProperty("采购项目ID")
    private Long procurementProjectId;

}
