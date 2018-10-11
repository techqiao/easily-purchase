package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BankAccountVO implements Serializable {

    private String proceedsUnit;

    private String bankOfDeposit;

    private String shroffAccountNumber;

    private String wholesaleLineNumber;

    private String locationLineNumber;

}
