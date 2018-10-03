package com.epc.web.service.domain.purchaser;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TPurchaserExpert implements Serializable {

    private Long id;

    private Integer state;

    private Long expertId;

    private String purchaserId;

    private Long createrId;

    private String source;

    private Date createAt;


    private Date updateAt;


    private Integer isDeleted;


    private static final long serialVersionUID = 1L;

}