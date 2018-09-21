package com.epc.web.facade.bidding.query.downLoad;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPretriaMessageDTO implements Serializable {

    private Long supplierId;
    private Long noticeId;
    private Long purchasProjectId;

}
