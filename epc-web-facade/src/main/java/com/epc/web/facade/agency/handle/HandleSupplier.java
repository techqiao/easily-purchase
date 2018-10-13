package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author winlin
 */
@Data
public class HandleSupplier implements Serializable{
    private static final long serialVersionUID = -4415097552756757466L;
    private Long id;


    private String name;


    private String cellphone;


    private String password;


    private Long supplierId;

    private Long inviterId;


    private Integer inviterCompanyId;


    private Integer state;


    private Integer role;


    private String companyName;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;
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
     * 身份证反面
     */
    private List<Attachement>  atts;

    private String companyAddress;

    private String province;

    private String city;

    private String area;

}
