package com.epc.web.facade.operator.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TSupplierBasicInfoVO implements Serializable {
    private static final long serialVersionUID = -297094904128603269L;

    private Long id;


    private String name;


    private String cellphone;


//    private String password;


//    private Long supplierId;

//    private Integer inviterType;


    private Long inviterId;


    private Integer inviterCompanyId;


    private Integer state;


//    private Integer role;


    private String createAt;



//    private Integer isDeleted;

    private Integer isForbidden;


}
