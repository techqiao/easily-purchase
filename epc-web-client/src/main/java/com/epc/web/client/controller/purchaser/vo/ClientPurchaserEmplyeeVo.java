package com.epc.web.client.controller.purchaser.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientPurchaserEmplyeeVo implements Serializable{
    private static final long serialVersionUID = -4452162040219807127L;
    private String userId;
    private String userName;
    private String cellphone;
    private String companyId;
    private String bossName;
    private String companyName;
}
