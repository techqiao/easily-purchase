package com.epc.web.facade.agency.vo;

import com.epc.web.facade.agency.handle.Attachement;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class AgencySupplierVo implements Serializable {
    private static final long serialVersionUID = -6368258212851191773L;
    /**
     * 代理机构员工的名称
     */
    private String employeeName;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    /**
     * 统一信用证号
     */
    private String uniformCreditCode;
    /**
     * 对公银行
     */
    private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBanAccountNumber;
    /**
     * 法人手机号
     */
    private String cellphone;
    /**
     * 资料集合
     */
        private List<Attachement> atts;
    /**
     * 代理机构供应商id
     */
    private Long supplierId;
}