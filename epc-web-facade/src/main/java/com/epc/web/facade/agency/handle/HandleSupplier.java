package com.epc.web.facade.agency.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author winlin
 */
@Data
public class HandleSupplier implements Serializable{
    private static final long serialVersionUID = -4415097552756757466L;
    private String name;

    private String cellphone;

    private String password;

    private String agencyId;

    private String source;

    private Integer inviterType;

    private String companyName;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;
}
