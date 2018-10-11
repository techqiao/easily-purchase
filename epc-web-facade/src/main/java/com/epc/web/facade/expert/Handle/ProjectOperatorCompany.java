package com.epc.web.facade.expert.Handle;

import lombok.Data;

import java.io.Serializable;
@Data
public class ProjectOperatorCompany implements Serializable {
    private static final long serialVersionUID = 6263619713917645011L;
    private Long operatorId;
    private String companyName;
}
