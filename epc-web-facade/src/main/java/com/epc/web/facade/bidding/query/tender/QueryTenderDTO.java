package com.epc.web.facade.bidding.query.tender;


import com.epc.common.PagerParam;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryTenderDTO extends PagerParam implements Serializable {
    private static final long serialVersionUID = 7595673216080302862L;
    private Long purchasProgramId;
}
