package com.epc.web.facade.enrolmentinvitation.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BSignUpVO implements Serializable {
    private static final long serialVersionUID = 7142518449506108835L;
    private Long id;

    private Long projectId;

    private Long procurementProjectId;

    private String bidsId;

    private String bidsName;

    private Long supplierId;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;
}
