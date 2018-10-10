package com.epc.web.facade.expert.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExpertProjectVo implements Serializable {
    private static final long serialVersionUID = 5118535404845708L;
    /**
     * 序号
     */
    private Integer serialNum;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目编号
     */
    private Integer projectNum;
    /**
     * 采购方式
     */
    private  String purchaserMode;
    /**
     * 招标状态
     */
    private String projectState;
    /**
     * 创建时间
     */
    private Date  createAt;
    /**
     * 评价
     */
    private String evaluation;
}
