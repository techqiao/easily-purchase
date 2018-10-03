package com.epc.web.facade.purchaser.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HandlePurchaserDto implements Serializable {
    private static final long serialVersionUID = 5864407821332405515L;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;
    /**
     *手机号
     */
    private String cellphone;
    /**
     * 用户角色
     */
    private Integer role;
    /**
     * 更新时间
     */
    private Date updateAt;
}
