package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoSubVO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-19 11:22
 * <p>@Author : wjq
 */
public interface FacadePurchaseProjectBidService {
    /**
     * 新增|修改|删除标段
     * @param handleBidsBasicInfo
     * @return
     */
    @PostMapping(value = "handleBidsBasicInfo", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleBidsBasicInfo(@RequestBody HandleBidsBasicInfo handleBidsBasicInfo);

    /**
     * 查询标段详情
     * @param bidId
     * @return
     */
    @GetMapping(value = "getBidsDetailInfo", consumes = "application/json; charset=UTF-8")
    Result<BidsBasicInfoSubVO> getBidsDetailInfo(@RequestParam(value = "bidId") Long bidId);

    /**
     * 查看标段列表
     * @param queryBidsDTO
     * @return
     */
    @PostMapping(value = "getBidsList", consumes = "application/json; charset=UTF-8")
    Result<List<BidsBasicInfoVO>> getBidsList(@RequestBody QueryBidsDTO queryBidsDTO);

}
