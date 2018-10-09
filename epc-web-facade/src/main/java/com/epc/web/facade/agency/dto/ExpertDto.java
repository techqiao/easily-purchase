package com.epc.web.facade.agency.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class ExpertDto implements Serializable  {
    private static final long serialVersionUID = -4794899765260032851L;

    /**
     * 专家姓名
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
     * 工作年限
     */

    private Integer workingYears;



}
