package com.epc.web.facade.purchaser.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PurchaserEmplyeeVo implements Serializable{
    private static final long serialVersionUID = 2270354322343913257L;
    private String userId;
    private String userName;
    private String cellphone;
    private String companyId;
    private String bossName;
    private String companyName;
}
