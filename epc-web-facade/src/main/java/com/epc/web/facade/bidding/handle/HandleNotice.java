package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HandleNotice implements Serializable {
    private static final long serialVersionUID = 5845152039029333899L;

    private Long id;

    private Long purchaseProjectId;

    private Long bidsId;

    private String bidsName;

    private String delegator;

    private String identitCard;

    private String bailmentPath;

    private String bidAppendix;

    private Long isDelete;

    private Long companyId;

    private String companyName;

    private Long operateId;

    private String ip;
    private List<BasePretriaFile> filePathList;
    private Entrust entrust;
}
