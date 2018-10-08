package com.epc.bidding.service.schedule;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.schedule.HandleProjectSchedule;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;

public interface ScheduleService {

    /**
     * 根据bid 和 用户类型 判断标段环节步骤
     * @param dto
     * @return
     */
    Result<String> queryProjectSchedule(QueryProjectSchedule dto);


    /**
     * 环节插入
     * @param dto
     * @return
     */
    Result<Boolean> insertProjectSchedule(HandleProjectSchedule dto);

}
