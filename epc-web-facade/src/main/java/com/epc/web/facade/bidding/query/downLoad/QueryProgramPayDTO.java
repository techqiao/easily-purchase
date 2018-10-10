package com.epc.web.facade.bidding.query.downLoad;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class QueryProgramPayDTO implements Serializable {

    private static final long serialVersionUID = -7947117795961660137L;
    private Long procurementProjectId;
    private Long companyId;
    private BigDecimal money;

    public Long getProcurementProjectId() {
        return procurementProjectId;
    }

    public void setProcurementProjectId(Long procurementProjectId) {
        this.procurementProjectId = procurementProjectId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
