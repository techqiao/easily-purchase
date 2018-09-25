package com.epc.tendering.service.controller.pretrial;

import com.epc.common.Result;
import com.epc.tendering.service.service.pretrial.PretrialMessageService;
import com.epc.web.facade.terdering.pretrial.FacadePretrialMessageService;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 11:15
 * <p>@Author : wjq
 */
@RestController
public class TFacadePretrialMessageController implements FacadePretrialMessageService {
    @Autowired
    private PretrialMessageService pretrialMessageService;
    @Override
    public Result<List<PretrialMessageVO>> getPretrialMessageList(QueryMessageDTO queryMessageDTO) {
        return pretrialMessageService.getPretrialMessageList(queryMessageDTO);
    }

    @Override
    public Result<Boolean> handlePretrialMessage(HandlePretrialMessage handlePretrialMessage) {
        return pretrialMessageService.handlePretrialMessage(handlePretrialMessage);
    }
}
