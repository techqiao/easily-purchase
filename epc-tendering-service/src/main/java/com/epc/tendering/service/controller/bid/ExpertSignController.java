package com.epc.tendering.service.controller.bid;

import com.epc.common.Result;
import com.epc.tendering.service.service.bid.ExpertSignService;
import com.epc.web.facade.terdering.bid.FacadeExpertSignService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.vo.ExpertSignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 19:46
 * <p>@Author : wjq
 */
@RestController
public class ExpertSignController implements FacadeExpertSignService {
    @Autowired
    private ExpertSignService expertSignService;

    @Override
    public Result<Boolean> insertExpertSign(@RequestBody HandleExpertSign handleExpertSign) {
        return expertSignService.insertExpertSign(handleExpertSign);
    }

    @Override
    public Result<Boolean> handleExpert(@RequestParam(value = "id") Long id) {
        return expertSignService.handleExpert(id);
    }

    @Override
    public Result<List<ExpertSignVO>> getExpertList(@RequestParam(value = "procurementProjectId") Long procurementProjectId) {
        return expertSignService.getExpertList(procurementProjectId);
    }
}
