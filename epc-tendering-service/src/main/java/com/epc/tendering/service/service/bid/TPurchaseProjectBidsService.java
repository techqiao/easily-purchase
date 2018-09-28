package com.epc.tendering.service.service.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoSubVO;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:29
 * <p>@Author : wjq
 */
public interface TPurchaseProjectBidsService {

    /**
     * 新增|修改 标段
     * @param handleBidsBasicInfo
     * @return
     */
    Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo);

    /**
     * 查询标段详情
     * @param bidId
     * @return
     */
    Result<BidsBasicInfoSubVO> getBidsDetailInfo(Long bidId);

    /**
     * 查询采购项目标段列表
     * @param queryBidsDTO
     * @return
     */
    Result<List<BidsBasicInfoSubVO>> getBidsList(QueryBidsDTO queryBidsDTO);

}
