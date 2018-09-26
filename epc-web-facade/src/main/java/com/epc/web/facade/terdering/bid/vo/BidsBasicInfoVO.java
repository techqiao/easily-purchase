package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 17:51
 * <p>@Author : wjq
 */
@Data
public class BidsBasicInfoVO implements Serializable {
    private static final long serialVersionUID = -8709235267947743537L;
    /**
     * 序号
     */
    private Long id;
    /**
     * 标段编码
     */
    private String bidCode;
    /**
     * 标段名称
     */
    private String bidName;
    /**
     * 标段文件路径
     */
    private String bidFilePath;
    /**
     * 创建时间
     */
    private Date createAt;

}
