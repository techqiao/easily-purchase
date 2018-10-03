package com.epc.web.facade.purchaser.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class QueryExpertDto implements Serializable {
    private static final long serialVersionUID = 8790267802592296215L;


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
}
