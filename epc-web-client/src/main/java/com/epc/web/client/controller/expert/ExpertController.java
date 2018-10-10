package com.epc.web.client.controller.expert;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.expert.handle.ClientHandleExpert;
import com.epc.web.client.controller.expert.handle.ClientIdleExpertDto;
import com.epc.web.client.remoteApi.expert.ExpertClient;
import com.epc.web.facade.agency.handle.HandleExpert;
import com.epc.web.facade.expert.dto.IdleExpertDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value="评标专家服务@winlin", description="专家服务接口")
@RestController
public class ExpertController  extends BaseController{
    @Autowired
    ExpertClient expertClient;
    /**
     *@author :winlin
     *@Description :专家完善信息服务
     *@date:2018/10/10
     */
    @ApiOperation(value = "专家完善信息" ,notes="专家注册后完善自己信息")
    @PostMapping(value = "/ExpertCompleteExpertInfo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> completeExpertInfo(@RequestBody ClientHandleExpert clientHandleExperte) {
        HandleExpert handleExpert = new HandleExpert();
        BeanUtils.copyProperties(clientHandleExperte,handleExpert);
        return expertClient.completeExpertInfo(handleExpert);
    }

    @ApiOperation(value = "专家修改信息" ,notes="专家修改自己信息")
    @PostMapping(value = "/ExpertUpdateExpertSelfInfo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> updateExpertSelfInfo(@RequestBody ClientHandleExpert clientHandleExperte) {
        HandleExpert handleExpert = new HandleExpert();
        BeanUtils.copyProperties(clientHandleExperte,handleExpert);
        return expertClient.completeExpertInfo(handleExpert);
    }

    @ApiOperation(value = "专家修改空闲状态" ,notes="专家修改空闲状态")
    @PostMapping(value = "/ExpertHasIntentionOrNot",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<Boolean> hasIntentionOrNot(@RequestBody ClientIdleExpertDto dto) {
        IdleExpertDto idleExpertDto = new IdleExpertDto();
        BeanUtils.copyProperties(dto,idleExpertDto);
        return expertClient.hasIntentionOrNot(idleExpertDto);
    }
}
