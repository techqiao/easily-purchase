package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.bid.OpeningRecordService;
import com.epc.web.facade.terdering.bid.FacadeOpeningRecordService;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;
import com.epc.web.facade.terdering.bid.vo.RecordVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 10:18
 * <p>@Author : wjq
 */
@RestController
public class OpeningRecordController extends BaseController implements FacadeOpeningRecordService {
    @Autowired
    private OpeningRecordService openingRecordService;

    @Override
    public Result<Boolean> insertOpeningRecord(@RequestBody List<HandleOpeningRecord> recordList) {
        return openingRecordService.insertOpeningRecord(recordList);
    }

    @Override
    public Result<Map<String, Object>> getOpeningRecordList(@RequestBody QueryBidsDTO queryBidsDTO) {
        PageHelper.startPage(queryBidsDTO.getPage(),queryBidsDTO.getRows());
        Result<List<RecordVO>> openingRecordList = openingRecordService.getOpeningRecordList(queryBidsDTO.getPurchaseProjectId());
        PageInfo<RecordVO> pageInfo = new PageInfo<>(openingRecordList.getData());
        return Result.success(getDataTable(pageInfo));
    }
}
