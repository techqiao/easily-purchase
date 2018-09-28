package com.epc.web.facade.terdering.committee.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleCommittee implements Serializable {

    private static final long serialVersionUID = -92267046920073132L;

    private Long procurementProjectId;

    private Integer totalNumber;

    private Integer platformExpertsNumber;

    private Integer ownerSpecialistsNumber;

    private Long OperateId;

}
