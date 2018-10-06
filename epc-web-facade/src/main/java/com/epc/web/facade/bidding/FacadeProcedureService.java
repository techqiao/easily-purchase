package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.schedule.HandleProjectSchedule;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: 查询标段流程
 * @Author: linzhixiang
 * @Date: 2018/10/4
 */ 
public interface FacadeProcedureService {

    @PostMapping(value = "queryProjectSchedule", consumes = "application/json; charset=UTF-8")
    Result<String> queryProjectSchedule(@RequestBody  QueryProjectSchedule dto);


    @PostMapping(value = "insertProjectSchedule", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertProjectSchedule(HandleProjectSchedule dto);

    }
