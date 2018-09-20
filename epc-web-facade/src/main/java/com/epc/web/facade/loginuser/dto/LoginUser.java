package com.epc.web.facade.loginuser.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    private String name;
    private String password;
    private String cellphone;
    private Integer type;
    private String bossId;
    private String bossName;
    private String selfId;
    private String CompanyName;
}
