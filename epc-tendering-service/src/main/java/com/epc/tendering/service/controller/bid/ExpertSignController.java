package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.bid.ExpertSignService;
import com.epc.web.facade.terdering.bid.FacadeExpertSignService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.query.QueryExpertDTO;
import com.epc.web.facade.terdering.bid.vo.SignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Result<List<SignVO>> getExpertList(@RequestBody QueryExpertDTO queryExpertDTO) {
        return expertSignService.getExpertList(queryExpertDTO.getProcurementProjectId());
    }
}
