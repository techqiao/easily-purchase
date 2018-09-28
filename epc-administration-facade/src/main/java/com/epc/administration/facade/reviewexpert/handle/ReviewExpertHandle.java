package com.epc.administration.facade.reviewexpert.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 01
 */
@Data
public class ReviewExpertHandle implements Serializable {
    private static final long serialVersionUID = -2265620201281709989L;
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
