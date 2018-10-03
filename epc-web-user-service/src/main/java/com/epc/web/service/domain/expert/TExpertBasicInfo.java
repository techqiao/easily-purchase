package com.epc.web.service.domain.expert;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TExpertBasicInfo implements Serializable {

    private Long id;


    private String name;


    private String cellphone;


    private String profession;


    private String positional;


    private String level;

    private Integer isIdle;
    private Date circularDt;


    private String circularMethod;

    private String otherInformation;


    private String password;


    private Integer inviterType;


    private Long inviterId;


    private Integer inviterCompanyId;


    private Integer state;


    private Date createAt;


    private Date updateAt;

    private Integer isForbidden;
    private Integer isDeleted;


    private static final long serialVersionUID = 1L;

}
