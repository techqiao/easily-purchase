package com.epc.administration.facade.operator.handle;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : 角色完善资料
 * <p>Date : 2018-09-11 16:07
 * <p>@Author : wjq
 */
@Data
public class RoleDetailInfo implements Serializable {

    private static final long serialVersionUID = -7643606947621478973L;
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
