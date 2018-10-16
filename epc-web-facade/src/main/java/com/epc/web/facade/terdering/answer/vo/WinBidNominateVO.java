package com.epc.web.facade.terdering.answer.vo;

import com.epc.web.facade.terdering.answer.query.FirstBidCompanyDTO;
import com.epc.web.facade.terdering.answer.query.SecondBidCompanyDTO;
import com.epc.web.facade.terdering.answer.query.ThreeBidCompanyDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WinBidNominateVO implements Serializable {

    private Long id;

    private String purchaseProjectName;

    private String purchaseProjectCode;

    private String bidName;

    private String bidCode;

    private FirstBidCompanyDTO firstBidCompany;

    private SecondBidCompanyDTO secondBidCompany;

    private ThreeBidCompanyDTO threeBidCompany;

    private String openStart;

    private String openEnd;

}
