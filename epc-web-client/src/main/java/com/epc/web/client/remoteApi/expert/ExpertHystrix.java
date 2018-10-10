package com.epc.web.client.remoteApi.expert;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.expert.FacadeExpertService;
import com.epc.web.facade.expert.dto.IdleExpertDto;

/**
 * @Author :winlin
 * @Description :
 * @Date:2018/9/15
 */
public class ExpertHystrix implements FacadeExpertService {

    @Override
    public Result<Boolean> completeExpertInfo(HandleExpert expert) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> updateExpertSelfInfo(HandleExpert expert) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> hasIntentionOrNot(IdleExpertDto dto) {
        return Result.hystrixError();
    }
}
