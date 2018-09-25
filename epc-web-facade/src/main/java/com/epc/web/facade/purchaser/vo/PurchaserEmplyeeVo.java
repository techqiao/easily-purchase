package com.epc.web.facade.purchaser.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PurchaserEmplyeeVo implements Serializable{
    private static final long serialVersionUID = 2270354322343913257L;
    /**
     * 员工Id
     */
    private String userId;
    /**
     * 员工姓名
     */
    private String userName;
    /**
     * 手机
     */
    private String cellphone;
    /**
     * 公司Id
     */
    private String companyId;
    /**
     * 法人姓名
     */
    private String bossName;
    /**
     * 公司名称
     */
    private String companyName;
}
