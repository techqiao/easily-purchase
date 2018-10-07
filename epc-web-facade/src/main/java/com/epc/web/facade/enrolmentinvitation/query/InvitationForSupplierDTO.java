package com.epc.web.facade.enrolmentinvitation.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvitationForSupplierDTO implements Serializable {
    private static final long serialVersionUID = 8729818146694636348L;
    private Long supplierId;
    private String supplierName;
}
