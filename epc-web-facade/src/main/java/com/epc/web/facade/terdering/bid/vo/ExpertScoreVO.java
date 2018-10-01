package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExpertScoreVO implements Serializable {
    private static final long serialVersionUID = 2265337564419432095L;
    private Long id;

    private Long bidsId;

    private String bidsCode;

    private Long supplierId;

    private String supplierCompanyName;

    private Double techTypeScore;

    private Double commerceTypeScore;

    private Double finalScore;

    private Long expertId;

    private String expertName;
}
