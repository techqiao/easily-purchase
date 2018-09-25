package com.epc.web.facade.bidding.handle;

import lombok.Data;

import java.io.Serializable;

@Data
public class HandleQuestion implements Serializable {

    private static final long serialVersionUID = 2633674461364958202L;

    private Long procurementProjectId;

    private Long questionerId;

    private String questionerName;

    private String problem;

    private String title;

}
