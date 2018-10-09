package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleWinBidFilePath implements Serializable {

    private Long id;
    private String filePath;
}
