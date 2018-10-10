package com.epc.web.facade.agency.handle;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class HandleExpert implements Serializable {

    private static final long serialVersionUID = 7406506628828438303L;
    private Long expertId;

    private String name;

    private String cellphone;

    private String profession;

    private String positional;

    private String level;

    private Date circularDt;

    private Date circularDtEnd;

    private String circularMethod;


    private Long inviterid;

    private String password;

    private String invterCompanyId;

    private String source;

    private String otherInformation;

    /**
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;
    /**
     * 授权书
     */
    private String certificateOfAuthorization;
    /**
     * 附件
     */
    private List<Attachement> atts;
}
