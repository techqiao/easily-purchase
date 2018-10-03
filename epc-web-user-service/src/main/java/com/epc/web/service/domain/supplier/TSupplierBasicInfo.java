package com.epc.web.service.domain.supplier;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TSupplierBasicInfo implements Serializable {

    private Long id;


    private String name;


    private String cellphone;


    private String password;


    private Long supplierId;

    private Integer inviterType;


    private Long inviterId;


    private Integer inviterCompanyId;


    private Integer state;


    private Integer role;


    private Date createAt;

    private Date updateAt;


    private Integer isDeleted;

    private Integer isForbidden;
    private static final long serialVersionUID = 1L;


}