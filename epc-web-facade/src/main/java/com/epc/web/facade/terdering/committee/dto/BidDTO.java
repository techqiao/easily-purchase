package com.epc.web.facade.terdering.committee.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BidDTO implements Serializable {

    private static final long serialVersionUID = 8899701938481435183L;

    private Long bidsId;

    private String bidsName;
}
