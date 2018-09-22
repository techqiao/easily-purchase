package com.epc.web.facade.agency.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class AgencySupplierDto implements Serializable {
    private static final long serialVersionUID = 631901486442300798L;
    private Long agencyId;
    private String companyName;
}
