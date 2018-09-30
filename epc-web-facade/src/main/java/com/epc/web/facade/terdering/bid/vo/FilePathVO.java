package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilePathVO implements Serializable {
    private static final long serialVersionUID = 7374001988393186631L;
    private Long companyId;

    private String companyName;

    private String bidAppendix;

}
