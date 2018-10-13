package com.epc.web.facade.terdering.committee.query;

import com.epc.web.facade.terdering.committee.dto.BidDTO;
import com.epc.web.facade.terdering.committee.dto.ExpertDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryExtractExpertList implements Serializable {

    private static final long serialVersionUID = 5472984522828487171L;
/**
 * BAssessmentCommittee
 */
    private Long committeeId;

/**
 *     BAssessmentCommitteeBid
 */

    List<ExpertDTO> expertDTOList;
    /**
     * 标段选择
     */
    List<BidDTO> bidDTOList;

    private Long OperateId;

    private Long procurementProjectId;
    private String province;

    private String city;

    private String area;

}
