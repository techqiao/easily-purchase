package com.epc.web.facade.terdering.pretrial;

import com.epc.common.Result;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:32
 * <p>@Author : wjq
 */
public interface FacadePretrialMessageService {

    /**
     * 查询资格审查列表
     * @param queryMessageDTO
     * @return
     */
    @PostMapping(value = "getPretrialMessageList", consumes = "application/json; charset=UTF-8")
    Result<Map<String, Object>> getPretrialMessageList(@RequestBody QueryMessageDTO queryMessageDTO);

    /**
     * 处理供应商是否通过资格审查
     * @param handlePretrialMessage
     * @return
     */
    @PostMapping(value = "handlePretrialMessage", consumes = "application/json; charset=UTF-8")
    Result<Boolean> handlePretrialMessage(@RequestBody HandlePretrialMessage handlePretrialMessage);


}
