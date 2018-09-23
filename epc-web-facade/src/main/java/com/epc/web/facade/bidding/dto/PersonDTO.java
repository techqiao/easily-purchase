package com.epc.web.facade.bidding.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1119946719598372004L;
    private String name;

    private String idCard;

}
