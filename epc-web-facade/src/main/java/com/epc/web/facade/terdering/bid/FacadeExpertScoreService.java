package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 09:57
 * <p>@Author : wjq
 */
public interface FacadeExpertScoreService {
    /**
     * 获取投标人列表
     * @param procurementProjectId 采购项目ID
     * @return
     */
    @GetMapping(value = "getBidderList", consumes = "application/json; charset=UTF-8")
    Result<List<BidderListVO>> getBidderList(@RequestParam(value = "procurementProjectId") Long procurementProjectId);

    /**
     * 专家评分
     * @param handleExpertScore
     * @return
     */
    @PostMapping(value = "handleExpertScore", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handleExpertScore(@RequestBody HandleExpertScore handleExpertScore);
}
