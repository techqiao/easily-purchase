package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleSign implements Serializable {
    private static final long serialVersionUID = -8510195427828284780L;
    private Long supplierId;
    private String name;
    private String cellPhone;
    private String companyName;
    private String identitCard;
    private Long procurementProjectId;
    private Long bidsId;
    private String bidsName;
}
