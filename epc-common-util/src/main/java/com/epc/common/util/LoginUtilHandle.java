package com.epc.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easilys
 * <p>Date : 2018-10-02 00:37
 * <p>@Author : luozhixin
 * <p>LoginUtilHandle
 */
@Data
public class LoginUtilHandle implements Serializable {
    private static final long serialVersionUID = 2919053648190754625L;

    private  String phone;
    private String  password;
    private String name;
    private Long id;

}
