package com.epc.web.facade.agency.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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


    private Long inviterid;

    private String password;

    private String invterCompanyId;

    private String source;

    private String otherInformation;

    private List<Attachement> atts;
}
