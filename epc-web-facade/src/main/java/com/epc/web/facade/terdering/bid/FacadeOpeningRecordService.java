package com.epc.web.facade.terdering.bid;

import com.epc.common.Result;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;
import com.epc.web.facade.terdering.bid.vo.RecordVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : 开标记录
 * <p>Date : 2018-09-26 10:04
 * <p>@Author : wjq
 */
public interface FacadeOpeningRecordService {

    /**
     * 插入开标记录
     * @param recordList
     * @return
     */
    @PostMapping(value = "insertOpeningRecord", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertOpeningRecord(@RequestBody List<HandleOpeningRecord> recordList);

    /**
     * 查询开标前置条件
     * @param queryBidsDTO
     * @return
     */
    @PostMapping(value = "getOpeningRecordList", consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> getOpeningRecordList(@RequestBody QueryBidsDTO queryBidsDTO);
}
