package com.epc.web.facade.purchaser.vo;

import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SupplierDetailVo implements Serializable{
    private static final long serialVersionUID = -2867895216705838544L;
    /**
     * 供货商公司的id
     */
    private Long supplierId;
    /**
     * 员工的名称
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
     * 法人姓名
     */
    private String name;
    /**
     * 资料集合
     */
    private List<Attachement> atts;
    /**
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;
    /**
     * 营业执照
     */
    private String businessLicense;
    private String companyAddress;
    private String province;
    private String city;
    private String area;


}
