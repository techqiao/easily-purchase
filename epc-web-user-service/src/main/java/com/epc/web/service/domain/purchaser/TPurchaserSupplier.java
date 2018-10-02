package com.epc.web.service.domain.purchaser;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TPurchaserSupplier implements Serializable {
    private Long id;


    private Integer state;

    private Long supplierId;

    private Integer operateId;
    private String source;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private String supplierType;

    private static final long serialVersionUID = 1L;



}