package com.epc.tendering.service.controller.pretrial;

import com.epc.common.Result;
import com.epc.tendering.service.controller.common.BaseController;
import com.epc.tendering.service.service.pretrial.PretrialMessageService;
import com.epc.web.facade.terdering.pretrial.FacadePretrialMessageService;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;
import com.epc.web.facade.terdering.project.vo.ProjectBasicInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-21 11:15
 * <p>@Author : wjq
 */
@RestController
public class TFacadePretrialMessageController extends BaseController implements FacadePretrialMessageService {
    @Autowired
    private PretrialMessageService pretrialMessageService;
    @Override
    public Result<Map<String, Object>> getPretrialMessageList(@RequestBody QueryMessageDTO queryMessageDTO) {
        PageHelper.startPage(queryMessageDTO.getPage(),queryMessageDTO.getRows());
        Result<List<PretrialMessageVO>> pretrialMessageList = pretrialMessageService.getPretrialMessageList(queryMessageDTO);
        PageInfo<PretrialMessageVO> pageInfo = new PageInfo<>(pretrialMessageList.getData());
        return Result.success(getDataTable(pageInfo));
    }

    @Override
    public Result<Boolean> handlePretrialMessage(@RequestBody HandlePretrialMessage handlePretrialMessage) {
        return pretrialMessageService.handlePretrialMessage(handlePretrialMessage);
    }
}
