package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BSaleDocumentsVO implements Serializable {

    private Long id;

    private Long procurementProjectId;

    private Long auditorId;

    private Long repliesId;

    private String biddingDocumentsUpUrl;

    private String biddingDocumentsDownloadUrl;

    private Integer isUnderLine;

    private Date biddingEndTime;

    private Date biddingBondEndTime;

    private Date bidOpeningTime;

    private String bidOpeningPlace;

    private Date clarificationProblemEndTime;

    private Integer decryptionMethod;

    private Integer processStatus;

    private Long operateId;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

}
