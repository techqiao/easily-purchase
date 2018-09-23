package com.epc.web.facade.bidding.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TenderVO {

    private Long id;

    private String bidCode;

    private String bidName;

    private String bidFilePath;

    private String bidMemo;

    private Date createAt;
}
