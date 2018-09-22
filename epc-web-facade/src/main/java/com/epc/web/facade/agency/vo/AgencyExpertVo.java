package com.epc.web.facade.agency.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class AgencyExpertVo implements Serializable {
    private static final long serialVersionUID = 2510071676535697755L;

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
     * 专家编号
     */
    private Long serialNum;
}
