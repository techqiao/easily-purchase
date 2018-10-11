package com.epc.web.facade.purchaser.dto;

import com.epc.web.facade.agency.handle.Attachement;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Data
public class HandleSupplierDto implements Serializable {
    private static final long serialVersionUID = 2913360236029186982L;
//    /**
//     * 采购人id
//     */
//    private Long purcharseId;
//    /**
//     * supplierId供货商id
//     */
//
//    private Long supplierId;
    /**
     * 手机号
     */
    private String cellphone;
//    /**
//     * 密码
//     */
//    private String password;

    /**
     * 法人姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 统一的信用代码
     */
    private String uniformCreditCode;
    /**
     * 对公银行name
     */
    private String publicBankName;
    /**
     * 对公银行账号
     */
    private String publicBankCount;

    /**
     * 操作人id
     */
    private Long OperatorId;
    /**
     * 操作人公司的id
     */
    private Long companyId;
    /**
     * 营业执照
     */
    private String businessLicense;
    /**
     * 身份证正面
     */
    private String legalIdCardPositive;
    /**
     * 身份证反面
     */
    private String legalIdCardOther;

    /**
     * 附件list
     */
    private List<Attachement> atts;
//    /**
//     * 来源
//     */
//    private String source;
    /**
     * 公司地址
     */
    private String companyAddress;

    private String province;

    private String city;

    private String area;

}
