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
    @ApiModelProperty(value = "法人身份证正面照片url")
    private String legalIdCardPositive;
    @ApiModelProperty(value = "法人身份证反面照片url")
    private String legalIdCardOther;
    @ApiModelProperty(value = "带公章的授权书照片url")
    private String certificateOfAuthorization;
    private List<Attachement>  atts;

}
