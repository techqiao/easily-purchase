package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
public class HandleExpert implements Serializable {

    private static final long serialVersionUID = 7406506628828438303L;
    private String name;

    private String cellphone;

    private String profession;

    private String positional;

    private String level;

    private Date circularDt;

    private String circularMethod;

    private Integer invitertype;

    private Long inviterid;

    private String password;

    private String invterCompanyId;

    private String source;


}
