package com.epc.mobile.facade.terdering.project.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = -2652851948582717583L;

    private Integer loginRole;
    private Long loginId;



}
