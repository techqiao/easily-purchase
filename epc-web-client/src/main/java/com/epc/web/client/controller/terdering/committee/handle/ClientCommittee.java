package com.epc.web.client.controller.terdering.committee.handle;

import com.epc.web.facade.terdering.committee.dto.BidDTO;
import com.epc.web.facade.terdering.committee.dto.ExpertDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
