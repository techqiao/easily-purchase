package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linzhixiang
 */
@Data
public class WinBidLetterVO implements Serializable {
    private static final long serialVersionUID = -5475351066938868221L;
    private Long id;

    private String projectName;

    private String projectCode;

    private String procurementProjectName;

    private String bidName;

    private String bidCode;

    private String filePath;

}
