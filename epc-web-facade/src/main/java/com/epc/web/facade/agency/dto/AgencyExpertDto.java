package com.epc.web.facade.agency.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class AgencyExpertDto implements Serializable {
    private static final long serialVersionUID = 5164901785641108018L;
    /**
     *专家姓名
     */
    private String expertName;
    /**
     * 庄家专业
     */
    private String profession;
    /**
     * 庄家职称
     */
    private String  positional;

    /**
     * 专家水平
     */
    private String level;
    /**
     * 代理机构id
     */
    private Long agencyId;
}
