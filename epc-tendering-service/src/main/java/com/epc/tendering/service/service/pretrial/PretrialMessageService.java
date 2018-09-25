package com.epc.tendering.service.service.pretrial;

import com.epc.common.Result;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:58
 * <p>@Author : wjq
 */
public interface PretrialMessageService {

    /**
     * 查询资格审查列表
     * @param queryMessageDTO
     * @return
     */
    Result<List<PretrialMessageVO>> getPretrialMessageList(QueryMessageDTO queryMessageDTO);

    /**
     * 处理供应商
     * @param handlePretrialMessage
     * @return
     */
    Result<Boolean> handlePretrialMessage(HandlePretrialMessage handlePretrialMessage);
}
