package com.epc.web.facade.purchaser.vo;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PurchaserExpertDetailVo implements Serializable {
    private static final long serialVersionUID = 5869627404476670719L;
    private String name;

    private String cellphone;

    private String profession;

    private String positional;

    private String level;

    private String otherInformation;

    private List<Attachement> atts;
}
