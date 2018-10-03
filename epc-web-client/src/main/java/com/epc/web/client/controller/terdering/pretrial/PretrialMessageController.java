package com.epc.web.client.controller.terdering.pretrial;

import com.epc.common.Result;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.controller.terdering.pretrial.handle.ClientHandleMessage;
import com.epc.web.client.controller.terdering.pretrial.query.ClientQueryMessageDTO;
import com.epc.web.client.remoteApi.pretrial.FacadePretrialMessageClient;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 11:17
 * <p>@Author : wjq
 */
@Api(value = "预审信息服务", tags = {"预审信息服务"})
@RestController
@RequestMapping(value = "/pretrial", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PretrialMessageController extends BaseController {
    @Autowired
    private FacadePretrialMessageClient pretrialMessageClient;

    @ApiOperation(value = "查询资格审查列表")
    @PostMapping(value="/getPretrialMessageList")
    public Result<List<PretrialMessageVO>> getPretrialMessageList(@RequestBody ClientQueryMessageDTO clientQueryMessageDTO) {
        QueryMessageDTO queryMessageDTO = new QueryMessageDTO();
        BeanUtils.copyProperties(clientQueryMessageDTO, queryMessageDTO);
        return pretrialMessageClient.getPretrialMessageList(queryMessageDTO);
    }


    @ApiOperation(value = "查询资格审查列表")
    @PostMapping(value="/handlePretrialMessage")
    public Result<Boolean> handlePretrialMessage(@RequestBody ClientHandleMessage clientHandleMessage){
        HandlePretrialMessage handlePretrialMessage = new HandlePretrialMessage();
        BeanUtils.copyProperties(clientHandleMessage, handlePretrialMessage);
        handlePretrialMessage.setCreator(getLoginUser().getName());
//        handlePretrialMessage.setOperateId(getLoginUser().getUserId());
        return pretrialMessageClient.handlePretrialMessage(handlePretrialMessage);
    }
}
