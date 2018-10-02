package com.epc.web.service.domain.supplier;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TSupplierDetailInfo implements Serializable {

    private Long id;


    private Long supplierId;


    private String companyName;


    private String uniformCreditCode;

    private String publicBankName;


    private String publicBanAccountNumber;


    private Date createAt;


    private Date updateAt;


    private Integer isDeleted;


    private static final long serialVersionUID = 1L;

}