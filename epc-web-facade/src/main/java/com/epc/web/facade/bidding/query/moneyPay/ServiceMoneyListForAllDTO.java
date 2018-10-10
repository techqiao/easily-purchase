package com.epc.web.facade.bidding.query.moneyPay;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class ServiceMoneyListForAllDTO implements Serializable {
    private String projectName;
    private Integer projectStatus;
    private String payStatus;
    private Long companyId;

}
