package com.epc.web.facade.bidding.query.winBid;

import lombok.Data;

@Data
public class QueryWinBidLetterDTO {

    private Long procurementProjectId;

    private Long bidId;

    private Long supplierId;
}
