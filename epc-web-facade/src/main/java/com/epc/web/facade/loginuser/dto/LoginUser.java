package com.epc.web.facade.loginuser.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    private String name;
    private String password;
    private String cellphone;
    private Integer type;
    private Long bossId;
    private String bossName;
    private Long userId;
    private String companyName;
}
