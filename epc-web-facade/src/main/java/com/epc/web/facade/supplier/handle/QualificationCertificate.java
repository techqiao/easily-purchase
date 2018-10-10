package com.epc.web.facade.supplier.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class QualificationCertificate implements Serializable {
    private static final long serialVersionUID = 4360311017447858381L;

    //资质证书url
    private String qualificationCertificate;
    private String qualificationCertificateNumber;
    private String qualificationCertificateName;
    private String qualificationCertificateType;


}
