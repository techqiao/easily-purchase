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
     *公司名称
     */
    private String companyName;
    /**
     * 统一信用代码
     */
    private String uniformCreditCode;
    /**
     * 对公银行名称
     */
    private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 是否删除: 0-存在,1-删除
     */
    private Integer isDeleted;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    private Integer state;
    /**
     * 用户名
     */
    private String name;
}
