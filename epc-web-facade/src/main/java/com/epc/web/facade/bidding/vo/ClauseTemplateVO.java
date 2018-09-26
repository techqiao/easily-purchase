package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : 废除条款模板
 * <p>Date : 2018-09-26 15:29
 * <p>@Author : luozhixin
 * <p>ClauseTemplateVO
 */
@Data
public class ClauseTemplateVO implements Serializable {
    private static final long serialVersionUID = -8777351647818075024L;

    /**
     *废除条款模板url
     */
    private  String filePath;
    /**
     *废除条款模板名称
     */
    private String clauseName;
}
