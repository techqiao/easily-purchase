package com.epc.web.facade.bidding.handle;

import lombok.Data;

@Data
public class HandleSign {
    private Long supplierId;
    private String name;
    private String cellPhone;
    private String companyName;
    private Long procurementProjectId;
    private Long bidsId;
    private String bidsName;
}
