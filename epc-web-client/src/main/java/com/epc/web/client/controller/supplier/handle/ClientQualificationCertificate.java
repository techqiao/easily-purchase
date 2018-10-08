package com.epc.web.client.controller.supplier.handle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ClientQualificationCertificate",description = "资质证书")
@Data
public class ClientQualificationCertificate  {

    //资质证书url
    @ApiModelProperty(value = "资质证书url")
    private String qualificationCertificate;
    @ApiModelProperty(value = "资质证书号码")
    private String qualificationCertificateNumber;
}
