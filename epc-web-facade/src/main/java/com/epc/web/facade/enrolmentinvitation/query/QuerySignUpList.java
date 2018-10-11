package com.epc.web.facade.enrolmentinvitation.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuerySignUpList implements Serializable {
    private static final long serialVersionUID = 2365622395349008597L;
    private Long purchaserId;
    private Long procurementProjectId;
}
