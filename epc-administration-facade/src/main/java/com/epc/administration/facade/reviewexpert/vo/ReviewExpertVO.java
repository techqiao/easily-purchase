package com.epc.administration.facade.reviewexpert.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 11:12
 * <p>@Author : luozhixin
 * <p>ReviewExpertVO
 */
@Data
public class ReviewExpertVO implements Serializable {
    private static final long serialVersionUID = 1216306802805694722L;
    /**
     * 主键
     */
    private Long id;
    /**
     *专家姓名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    private Integer state;

    /**
     * 专业
     */
    private String profession;

    /**
     * 职称
     */
    private String positional;

    /**
     * 级别
     */
    private String level;

}
