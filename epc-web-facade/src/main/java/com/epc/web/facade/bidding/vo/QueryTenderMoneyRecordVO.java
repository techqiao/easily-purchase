package com.epc.web.facade.bidding.vo;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author linzhixiang
 */
@lombok.Data
public class QueryTenderMoneyRecordVO implements Serializable {
    private static final long serialVersionUID = 5929308159997874094L;
    private Long procurementProjectId;
    private Long id;
    private Date biddingBondEndTime;
    private Long bidsId;
    private String bidsName;
    private BigDecimal tenderGuaranteeAmount;
    private String bankAccount;
    private String receivables;
    private Long tendererCompanyId;
    private BigDecimal  amountMoney;
    private Data createAt;
}
