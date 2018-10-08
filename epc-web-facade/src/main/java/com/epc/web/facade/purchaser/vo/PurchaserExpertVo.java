package com.epc.web.facade.purchaser.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class PurchaserExpertVo implements Serializable {
    private static final long serialVersionUID = -351531377573568471L;

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
     * 专家编号就是专家id
     */
    private Long serialNum;
}
