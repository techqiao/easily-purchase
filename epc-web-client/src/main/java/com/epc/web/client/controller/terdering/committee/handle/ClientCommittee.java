package com.epc.web.client.controller.terdering.committee.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @Description: 组建委员会信息
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel(value = "组建委员会信息")
public class ClientCommittee implements Serializable {

    private static final long serialVersionUID = 3896139937334008600L;
    @ApiModelProperty(value = "采购项目Id")
    private Long procurementProjectId;
    @ApiModelProperty(value = "总人数")
    private Integer totalNumber;
    @ApiModelProperty(value = "平台专家数量")
    private Integer platformExpertsNumber;
    @ApiModelProperty(value = "业主专家数量")
    private Integer ownerSpecialistsNumber;
    @ApiModelProperty(value = "操作人ID")
    private Long OperateId;

}
