package com.epc.web.facade.purchaser.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleAgencyDto  implements Serializable{
    private static final long serialVersionUID = 8175917442414344896L;

    private Long purchaseId;
}
