package com.epc.administration.facade.biddingagency.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author luozhixin
 */
@Data
public class BiddingHandle implements Serializable {
    private static final long serialVersionUID = 2295340220100317777L;
    private String systemRole;
    private Long userId;
    private String companyName;
    private String publicBankName;
    private String publicBanAccountNumber;
    private List<String> qualificationCertificateList;
    private String businessLicense;
    private String legalIdCardPositive;
    private String legalIdCardOther;
    private String certificateOfAuthorization;
    private String operatorIdCardFront;


}
