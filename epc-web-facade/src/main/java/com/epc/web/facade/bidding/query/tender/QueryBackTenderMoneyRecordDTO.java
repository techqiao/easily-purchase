package com.epc.web.facade.bidding.query.tender;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryBackTenderMoneyRecordDTO implements Serializable {
    private static final long serialVersionUID = -966103363414203576L;
    private Long procurementProjectId;
    private Long tendererCompanyId;
}
