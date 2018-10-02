package com.epc.web.service.domain.purchaser;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TPurchaserBasicInfo implements Serializable {
    private static final long serialVersionUID = 7078461356391331853L;
    private Long id;
    private String name;
    private String cellphone;
    private String password;
    private Long purchaserId;
    private Integer inviterType;
    private Integer inviterId;
    private Integer inviterCompanyId;
    private Integer isForbidden;
    private Integer state;
    private Integer role;
    private Date createAt;
    private Date updateAt;
    private Integer isDeleted;

}