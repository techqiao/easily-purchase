package com.epc.web.facade.bidding.query.sign;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuerySignerDTO implements Serializable {
    private static final long serialVersionUID = 4394439969681802543L;
    private Long bidId;
    private String name;
    private String cellPhone;
    private String idCard;
}
