package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HandlePretriaFile implements Serializable {
    private static final long serialVersionUID = 4136754272238787996L;

    private Long id;

    private Long purchaseProjectId;

    private Long bidId;

    private Long releaseAnnouncementId;

    private Long companyId;

    private Long operateId;

    private String operateName;

    private String content;

    private List<BasePretriaFile> filePathList;

}
