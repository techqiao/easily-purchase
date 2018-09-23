package com.epc.web.facade.bidding.query.tender;

import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPersonDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = 236072143731594167L;
    private Long supplierId;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
