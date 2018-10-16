package com.epc.web.facade.terdering.answer.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("第三中标人")
public class ThreeBidCompanyDTO implements Serializable {

    @ApiModelProperty("公司名称")
    private String companyName;
    @ApiModelProperty("投标金额")
    private BigDecimal money;

    @ApiModelProperty("工程质量目标")
    private String qualityTarget;

    @ApiModelProperty("工期")
    private Integer duration;

    @ApiModelProperty("投标有效期")
    private Integer validity;

    @ApiModelProperty("项目经理姓名")
    private String managerName;

    @ApiModelProperty("执业证书号码")
    private String certificateNumber;
}
