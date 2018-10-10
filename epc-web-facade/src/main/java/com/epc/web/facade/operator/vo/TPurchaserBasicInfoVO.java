package com.epc.web.facade.operator.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TPurchaserBasicInfoVO implements Serializable {
    private static final long serialVersionUID = -2133998896046223004L;

    private Long id;
    private String name;
    private String cellphone;
//    private String password;
    private Long purchaserId;
    private Integer inviterType;
    private Integer inviterId;
    private Integer inviterCompanyId;
    private Integer isForbidden;
//    private Integer isDeleted;
    private Integer state;
    private Integer role;
    private String createAt;
    private String updateAt;



}
