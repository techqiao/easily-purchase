package com.epc.web.service.domain.agency;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TAgencyBasicInfo implements Serializable {
    private Long id;

    private String name;

    private Long agencyId;

    private String cellphone;

    private String password;

    private Integer inviterType;

    private Long inviterId;

    private Integer inviterCompanyId;

    private Integer state;

    private Integer role;

    private Date createAt;

    private Date updateAt;

    private Integer isForbidden;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;


}