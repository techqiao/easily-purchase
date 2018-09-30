package com.epc.administration.facade.biddingagency.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-30 09:30
 * <p>@Author : luozhixin
 * <p>AgencyUserAttachmentVO
 */
@Data
public class AgencyUserAttachmentVO extends BiddingAgencyVO implements Serializable {

    private static final long serialVersionUID = 6869267792661617405L;

    private List<AgencyAttachmentVO> agencyAttachmentVOS;

}
