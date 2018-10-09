package com.epc.web.client.remoteApi.pretrial;

import com.epc.common.Result;
import com.epc.web.facade.terdering.pretrial.FacadePretrialMessageService;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:52
 * <p>@Author : wjq
 */
public class FacadePretrialMessageHystrix implements FacadePretrialMessageService {
    @Override
    public Result<Map<String, Object>> getPretrialMessageList(QueryMessageDTO queryMessageDTO) {
        return Result.hystrixError();
    }

    @Override
    public Result<Boolean> handlePretrialMessage(HandlePretrialMessage handlePretrialMessage) {
        return Result.hystrixError();
    }
}
