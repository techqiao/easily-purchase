package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.bid.ExpertSignService;
import com.epc.web.facade.terdering.bid.FacadeExpertSignService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.query.QueryExpertDTO;
import com.epc.web.facade.terdering.bid.vo.ExpertSignVO;
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
 * <p>Date : 2018-09-26 19:46
 * <p>@Author : wjq
 */
@RestController
public class ExpertSignController extends BaseController implements FacadeExpertSignService {
    @Autowired
    private ExpertSignService expertSignService;

    @Override
    public Result<Boolean> insertExpertSign(@RequestBody HandleExpertSign handleExpertSign) {
        return expertSignService.insertExpertSign(handleExpertSign);
    }

    @Override
    public Result<Boolean> handleExpert(@RequestBody HandleExpertSign handleExpertSign) {
        return expertSignService.handleExpert(handleExpertSign);
    }

    @Override
    public Result<Map<String, Object>> getExpertList(@RequestBody QueryExpertDTO queryExpertDTO) {
        PageHelper.startPage(queryExpertDTO.getPage(),queryExpertDTO.getRows());
        Result<List<ExpertSignVO>> expertList = expertSignService.getExpertList(queryExpertDTO.getProcurementProjectId());
        PageInfo<ExpertSignVO> pageInfo = new PageInfo<>(expertList.getData());
        return Result.success(getDataTable(pageInfo));
    }
}
