package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "HandleEmployee",description = "代理机构员工信息")
public class HandleEmployee implements Serializable {

    private static final long serialVersionUID = -373772042506965841L;

    private Long id;

    private String name;

    private Long agencyId;


    private String cellphone;


    private String password;

    private Integer state;


    private Integer role;

    private Date createAt;
    private Date updateAt;

}
