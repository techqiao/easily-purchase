package com.epc.administration.facade.biddingagency.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-28 11:13
 * <p>@Author : luozhixin
 * <p>BiddingAgencyVO
 */
@Data
public class BiddingAgencyVO implements Serializable {
    private static final long serialVersionUID = -4880416669050089699L;
    /**
     * 法人id
     */
    @ApiModelProperty("法人id")
    private Long id;
    /**
     *公司名称
     */
    @ApiModelProperty("公司名称")
    private String companyName;
    /**
     * 统一信用代码
     */
    @ApiModelProperty("统一信用代码")
    private String uniformCreditCode;
    /**
     * 对公银行名称
     */
    @ApiModelProperty("对公银行名称")
    private String publicBankName;
    /**
     * 对公银行账号
     */
    @ApiModelProperty("对公银行账号")
    private String publicBanAccountNumber;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createAt;
    /**
     * 是否删除: 0-存在,1-删除
     */
    @ApiModelProperty("是否删除: 0-存在,1-删除")
    private Integer isDeleted;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String cellphone;
    /**
     * 0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败
     */
    @ApiModelProperty("0-已注册, 1-完善中, 2-已提交, 3-审核通过, 4-审核失败")
    private Integer state;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;
}
