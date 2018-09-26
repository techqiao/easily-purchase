package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BidAnnouncementVO implements Serializable {
    private static final long serialVersionUID = -3189359100141232432L;
    private String bid_appendix;
    private Long companyId;
    private String companyName;

}
