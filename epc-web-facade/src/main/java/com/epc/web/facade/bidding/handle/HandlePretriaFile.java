package com.epc.web.facade.bidding.handle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class HandlePretriaFile implements Serializable {
    private static final long serialVersionUID = 4136754272238787996L;

    private Long id;

    private Long bidId;

    private Long purchaseProjectId;

    private Long releaseAnnouncementId;

    private Long companyId;

    private String companyName;

    private Long operateId;

    private String operateName;

    private String content;

    private Long  isDelete;

    private List<BasePretriaFile> filePathList;

}
