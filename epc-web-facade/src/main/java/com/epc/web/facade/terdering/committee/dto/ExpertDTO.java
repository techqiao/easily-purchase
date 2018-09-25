package com.epc.web.facade.terdering.committee.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExpertDTO implements Serializable {
    private static final long serialVersionUID = -4737881527354386581L;
    private Integer professionalNumber;

    private String professionalName;

    private String professionalLevel;
}
