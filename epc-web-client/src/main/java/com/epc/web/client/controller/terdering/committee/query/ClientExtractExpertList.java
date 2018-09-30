package com.epc.web.client.controller.terdering.committee.query;

import com.epc.web.facade.terdering.committee.dto.BidDTO;
import com.epc.web.facade.terdering.committee.dto.ExpertDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * @Description: 组建委员会
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Data
@ApiModel(value = "组建委员会")
public class ClientExtractExpertList implements Serializable {

    private static final long serialVersionUID = 5472984522828487171L;
    /**
    BAssessmentCommitteeBid
     */

    @ApiModelProperty(value = "委员会ID")
    private Long committeeId;

    @ApiModelProperty(value = "专家属性")
    List<ExpertDTO> expertDTOList;
    /**
     * 标段选择
     */
    @ApiModelProperty(value = "标段列表")
    List<BidDTO> bidDTOList;
    @ApiModelProperty(value = "操作人ID")
    private Long OperateId;

}
