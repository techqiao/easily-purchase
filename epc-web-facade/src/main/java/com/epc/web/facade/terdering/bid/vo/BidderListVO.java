package com.epc.web.facade.terdering.bid.vo;

import lombok.Data;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 09:59
 * <p>@Author : wjq
 */
@Data
public class BidderListVO {
    /**
     * 标段ID
     */
    private Long bidsId;
    /**
     * 投标人列表
     */
    private List<BidderVO> bidderVOList;
}
