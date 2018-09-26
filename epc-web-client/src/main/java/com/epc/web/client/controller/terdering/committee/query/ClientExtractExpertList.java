package com.epc.web.client.controller.terdering.committee.query;

import com.epc.web.facade.terdering.committee.dto.BidDTO;
import com.epc.web.facade.terdering.committee.dto.ExpertDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "组建委员会")
public class ClientExtractExpertList implements Serializable {

    private static final long serialVersionUID = 5472984522828487171L;
/**
 * BAssessmentCommittee
 */
    @ApiModelProperty(value = "采购项目Id")
    private Long procurementProjectId;
    @ApiModelProperty(value = "总人数")
    private Integer totalNumber;
    @ApiModelProperty(value = "平台专家数量")
    private Integer platformExpertsNumber;
    @ApiModelProperty(value = "业主专家数量")
    private Integer ownerSpecialistsNumber;
    /**
    BAssessmentCommitteeBid
    */
    @ApiModelProperty(value = "专家属性")
    List<ExpertDTO> expertDTOList;
    /**
     * 标段选择
     */
    @ApiModelProperty(value = "标段列表")
    List<BidDTO> bidDTOList;
    @ApiModelProperty(value = "操作人ID")
    private Long OperateId;
    @ApiModelProperty(value = "供应商ID")
    private Long purchaserId;

}
