package com.epc.web.facade.purchaser.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class PurchaserEmplyeeVo implements Serializable{
    private static final long serialVersionUID = 2270354322343913257L;
    /**
     * 员工Id
     */
    private String userId;
    /**
     * 员工姓名
     */
    private String userName;
    /**
     * 手机
     */
    private String cellphone;
    /**
     * 公司Id
     */
    private String companyId;
    /**
     * 法人姓名
     */
    private String bossName;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 员工状态
     */
    private Integer state;
    /**
     * 加入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
}
