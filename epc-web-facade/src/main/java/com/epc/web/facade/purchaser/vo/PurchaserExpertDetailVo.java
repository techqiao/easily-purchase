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

    /**
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 专家公司
     */
    private String company;

    private List<Attachement> atts;
}
