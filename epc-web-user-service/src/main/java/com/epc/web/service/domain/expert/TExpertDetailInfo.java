package com.epc.web.service.domain.expert;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TExpertDetailInfo implements Serializable {
    private Long id;

    private Long expertId;

    private String companyName;

    private String province;
    private String city;
    private String area;

    private String companyAddress;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;

    private String extendedField;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;


}