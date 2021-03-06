package com.epc.web.facade.terdering.project.query;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-18 15:58
 * <p>@Author : wjq
 */
@Data
public class QueryProjectInfoDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = 4042231390090081081L;
    /**
     * 采购人ID
     */
    private Long purchaserId;

    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 项目名称
     */
    private String projectName;
}
