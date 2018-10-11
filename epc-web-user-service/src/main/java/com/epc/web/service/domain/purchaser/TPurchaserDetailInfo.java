package com.epc.web.service.domain.purchaser;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TPurchaserDetailInfo implements Serializable {

    private Long id;


    private Long purchaserId;


    private String companyName;


    private String uniformCreditCode;


    private String publicBankName;


    private String publicBanAccountNumber;


    private String extendedField;

    private Date createAt;


    private Date updateAt;


    private Integer isDeleted;
    private String province;
    private String city;
    private String area;
    private String companyAddress;

    private static final long serialVersionUID = 1L;


}