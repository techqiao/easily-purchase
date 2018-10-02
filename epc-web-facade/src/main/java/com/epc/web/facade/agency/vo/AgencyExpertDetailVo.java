package com.epc.web.facade.agency.vo;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class AgencyExpertDetailVo implements Serializable {
    private static final long serialVersionUID = 8991313575436037876L;
    private String name;

    private String cellphone;

    private String profession;

    private String positional;

    private String level;

    private String otherInformation;

    private List<Attachement> atts;
}
