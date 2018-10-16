package com.epc.mobile.facade.loginer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 01
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1652716944499144386L;
    private String name;
    private String password;
    private String cellphone;
    private Integer type;
    private Long bossId;
    private String bossName;
    private Long userId;
    private String companyName;
    private Long companyId;
    private Integer loginRole;
    private Integer state;

}
