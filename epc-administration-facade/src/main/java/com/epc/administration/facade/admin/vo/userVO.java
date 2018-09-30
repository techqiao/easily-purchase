package com.epc.administration.facade.admin.vo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-29 17:45
 * <p>@Author : luozhixin
 * <p>userVO
 */
@Data
public class userVO {
    private  Long id;
    private String name;
    private String phone;
    private Date crateTime;
    private  String deptName;
}
