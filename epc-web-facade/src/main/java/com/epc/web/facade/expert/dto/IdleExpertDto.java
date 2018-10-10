package com.epc.web.facade.expert.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class IdleExpertDto implements Serializable {
    private static final long serialVersionUID = -3087948516812207911L;
    private Long expertId;
    private Integer idle;
}
