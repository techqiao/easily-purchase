package com.epc.web.facade.bidding.query.notice;

import lombok.Data;

import java.io.Serializable;
@Data
public class PretrialMessageDTO implements Serializable {
    private Long noticeId;
    private Long supplierId;
}
