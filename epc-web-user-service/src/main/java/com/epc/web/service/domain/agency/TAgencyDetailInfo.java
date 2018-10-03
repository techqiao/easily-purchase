package com.epc.web.service.domain.agency;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TAgencyDetailInfo implements Serializable {

    private Long id;


    private Long agencyId;


    private String companyName;


    private String uniformCreditCode;


    private String publicBankName;


    private String publicBanAccountNumber;

    private Date createAt;


    private Date updateAt;


    private Integer isDeleted;

    private static final long serialVersionUID = 1L;


}