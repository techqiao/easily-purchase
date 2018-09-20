package com.epc.web.facade.agency.handle;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 *@author :winlin
 *@Description :
 *@param:
 *@return:
 *@date:2018/9/18
 */
@Data
public class HandleAgency implements Serializable {

    private static final long serialVersionUID = -5650940360397347119L;
    private String name;

    private String password;

    private String cellphone;

    private String companyName;

    private String uniformCreditCode;

    private String publicBankName;

    private String publicBanAccountNumber;

    private List<Attachement> atts;

}
