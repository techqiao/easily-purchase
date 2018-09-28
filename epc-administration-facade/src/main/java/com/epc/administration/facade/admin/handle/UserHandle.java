package com.epc.administration.facade.admin.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-14 20:28
 * <p>@Author : luozhixin
 */
@Data
public class UserHandle implements Serializable {
    private static final long serialVersionUID = -2906415443589618056L;
    private  String name;
    private  String phone;
    private String  password;
    private  Long depetid;
    private int isDeleted;
    private Long id;
    private Long[] roles;

}
