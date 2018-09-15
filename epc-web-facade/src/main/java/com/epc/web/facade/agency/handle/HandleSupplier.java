package com.epc.web.facade.agency.handle;

import lombok.Data;

@Data
public class HandleSupplier {

    private String name;

    private String cellphone;

    private String password;

    private String agencyId;

    private String source;

    private Integer inviterType;

    private String companyName;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;
}
