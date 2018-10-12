package com.epc.web.facade.bidding.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class IsPayDTO implements Serializable {
    private  Boolean isPay;
    private String filePath;
}
