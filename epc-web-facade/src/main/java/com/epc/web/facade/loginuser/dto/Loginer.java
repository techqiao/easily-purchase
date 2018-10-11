package com.epc.web.facade.loginuser.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class Loginer implements Serializable {

    private static final long serialVersionUID = 4433146134729408877L;
    private String cellphone;
    private String password;
    private Integer type;
    private String verityCode;
}
