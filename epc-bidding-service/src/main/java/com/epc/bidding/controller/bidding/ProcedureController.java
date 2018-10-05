package com.epc.bidding.controller.bidding;


import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeProcedureService;
import com.epc.web.facade.bidding.query.schedule.HandleProjectSchedule;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcedureController implements FacadeProcedureService {

    @Autowired
    BiddingService biddingService;

    /**
     * 查看采购项目流程列表
     * @param dto
     * @return
     */
    @Override
    public Result<String> queryProjectSchedule(@RequestBody QueryProjectSchedule dto){
      return  biddingService.queryProjectSchedule(dto);
    }

    @Override
    public Result<Boolean> insertProjectSchedule(@RequestBody HandleProjectSchedule dto){
        return  biddingService.insertProjectSchedule(dto);
    }


}
