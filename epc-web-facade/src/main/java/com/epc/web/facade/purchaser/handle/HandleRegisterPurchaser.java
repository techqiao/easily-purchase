package com.epc.web.facade.purchaser.handle;

import lombok.Data;

@Data
public class HandleRegisterPurchaser {
    /**
     * 用于接受数据库生成的的id
     */
    private Long purchaseId;
    /**
     * 代理商手机号
     */
    private String cellphone;
    /**
     * 密码
     */
    private String password;
}
