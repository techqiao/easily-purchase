package com.epc.tendering.service.service.pretrial.impl;

import com.epc.common.Result;
import com.epc.tendering.service.domain.pretrial.TPretrialFileCriteria;
import com.epc.tendering.service.domain.pretrial.TPretrialMessage;
import com.epc.tendering.service.domain.pretrial.TPretrialMessageCriteria;
import com.epc.tendering.service.mapper.pretrial.TPretrialFileMapper;
import com.epc.tendering.service.mapper.pretrial.TPretrialMessageMapper;
import com.epc.tendering.service.service.pretrial.PretrialMessageService;
import com.epc.web.facade.terdering.pretrial.handle.HandlePretrialMessage;
import com.epc.web.facade.terdering.pretrial.query.QueryMessageDTO;
import com.epc.web.facade.terdering.pretrial.vo.PretrialMessageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 10:58
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PretrialMessageServiceImpl implements PretrialMessageService {
    @Autowired
    private TPretrialMessageMapper tPretrialMessageMapper;
    @Autowired
    private TPretrialFileMapper tPretrialFileMapper;
    @Override
    public Result<List<PretrialMessageVO>> getPretrialMessageList(QueryMessageDTO queryMessageDTO) {
        final TPretrialMessageCriteria criteria = new TPretrialMessageCriteria();
        final TPretrialMessageCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andReleaseAnnouncementIdEqualTo(queryMessageDTO.getReleaseAnnouncementId());
        List<TPretrialMessage> messageList = tPretrialMessageMapper.selectByExampleWithRowbounds(criteria, queryMessageDTO.getRowBounds());
        List<PretrialMessageVO> returnList = new ArrayList<>();
        for (TPretrialMessage item : messageList) {
            PretrialMessageVO pojo = new PretrialMessageVO();
            BeanUtils.copyProperties(item, pojo);
            pojo.setUrl(tPretrialFileMapper.getFilePathById(item.getId()));
            returnList.add(pojo);
        }
        return Result.success(returnList);
    }

    @Override
    public Result<Boolean> handlePretrialMessage(HandlePretrialMessage handlePretrialMessage) {
        TPretrialMessage tPretrialMessage = new TPretrialMessage();
        BeanUtils.copyProperties(handlePretrialMessage, tPretrialMessage);
        tPretrialMessage.setUpdateAt(new Date());
        return Result.success(tPretrialMessageMapper.updateByPrimaryKeySelective(tPretrialMessage) > 0);
    }
}
