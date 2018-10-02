package com.epc.web.facade.purchaser.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Data
public class HandleSupplierDto implements Serializable {
    private static final long serialVersionUID = 2913360236029186982L;
    private Long purcharseId;
    private String companyName;
}
