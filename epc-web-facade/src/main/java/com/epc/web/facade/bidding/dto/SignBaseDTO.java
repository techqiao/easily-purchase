package com.epc.web.facade.bidding.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class SignBaseDTO implements Serializable {
    private static final long serialVersionUID = 7027776455997362497L;
    //机构ID
    private  Long  supplierId;
    private  String name;
    private  String cellphone;
    private  String companyName;

}
