package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleScoreReport implements Serializable {
    private static final long serialVersionUID = 745331002085740264L;
    private String filePath;

    private Long bidsId;

    private Long operateId;
    private String memo;
}
