package com.epc.web.facade.bidding.query.winBid;

import lombok.Data;

@Data
public class QueryWinBidDTO {

    private Long projectId;

    private Long procurementProjectId;

    private Long bidId;

}
