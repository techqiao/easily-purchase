package com.epc.web.facade.loginuser.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class ModifyUser implements Serializable {
    private static final long serialVersionUID = -6305707188721160155L;
    //private Integer type;
    private String cellphone;
    private String newPassword;
}
