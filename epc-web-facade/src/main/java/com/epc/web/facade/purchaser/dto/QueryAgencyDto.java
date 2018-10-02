package com.epc.web.facade.purchaser.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class QueryAgencyDto implements Serializable {
    private static final long serialVersionUID = -5247777178111471175L;
    /**
     * 机构id
     */
    private Long purchaserId;
    /**
     * 代理机构名字
     */
    private String name;

}
