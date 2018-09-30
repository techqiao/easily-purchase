package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 查看保证金返还
 * @Author: linzhixiang
 * @Date: 2018/9/28
 */ 
@Data
public class IsBackTenderMoneyRecordVO implements Serializable {
    private static final long serialVersionUID = -966103363414203576L;
    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 标段名称
     */
    private String bidsName;
    /**
     * 标段编号
     */
    private String bidsCode;
    /**
     * 是否返还
     */
    private Boolean isBack;
}
