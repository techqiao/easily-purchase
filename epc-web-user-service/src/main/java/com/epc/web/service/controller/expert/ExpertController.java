package com.epc.web.service.controller.expert;

import com.epc.common.Result;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.expert.FacadeExpertService;
import com.epc.web.facade.expert.dto.IdleExpertDto;
import com.epc.web.facade.expert.dto.ProjectDto;
import com.epc.web.service.service.expert.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winlin
 */
@RestController
public class ExpertController implements FacadeExpertService {
    @Autowired
    ExpertService expertService;

    @Override
    public Result<Boolean> completeExpertInfo(@RequestBody  HandleExpert expert) {
        return expertService.completeExpertInfo(expert);
    }

    @Override
    public Result<Boolean> updateExpertSelfInfo(@RequestBody HandleExpert expert) {
        return expertService.updateExpertSelfInfo(expert);
    }

    @Override
    public Result<Boolean> hasIntentionOrNot(@RequestBody IdleExpertDto dto) {
        return expertService.hasIntentionOrNot(dto);
    }

    @Override
    public Result selectAllBid(@RequestBody ProjectDto projecctDto) {
        return expertService.selectAllBid(projecctDto);
    }
}
