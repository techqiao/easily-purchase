package com.epc.web.facade.purchaser.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class QueryDto implements Serializable {
    private static final long serialVersionUID = -9018821914919354235L;
    /**
     * 用户id
     */
    private Long id;
}
