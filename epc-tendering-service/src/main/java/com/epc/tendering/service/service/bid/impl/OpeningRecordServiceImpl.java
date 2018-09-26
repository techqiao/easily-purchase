package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.tendering.service.domain.bid.BBidOpeningPayCriteria;
import com.epc.tendering.service.domain.bid.TTenderMessage;
import com.epc.tendering.service.domain.bid.TTenderMessageCriteria;
import com.epc.tendering.service.mapper.bid.BBidOpeningPayMapper;
import com.epc.tendering.service.mapper.bid.TOpeningRecordMapper;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.mapper.bid.TTenderMessageMapper;
import com.epc.tendering.service.service.bid.OpeningRecordService;
import com.epc.web.facade.terdering.bid.handle.HandleOpeningRecord;
import com.epc.web.facade.terdering.bid.vo.OpeningRecordVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 10:19
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OpeningRecordServiceImpl implements OpeningRecordService {
    @Autowired
    private TOpeningRecordMapper tOpeningRecordMapper;
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    private TTenderMessageMapper tTenderMessageMapper;
    @Autowired
    private BBidOpeningPayMapper bBidOpeningPayMapper;

    @Override
    public Result<Boolean> insertOpeningRecord(HandleOpeningRecord handleOpeningRecord) {
        //TODO
        return null;
    }

    @Override
    public Result<List<OpeningRecordVO>> getOpeningRecordList(Long purchaseProjectId) {
        //采购项目标段列表
        List<Long> bidsIdList = tPurchaseProjectBidsMapper.getBidsIdList(purchaseProjectId);
        final TTenderMessageCriteria criteria = new TTenderMessageCriteria();
        criteria.createCriteria().andPurchaseProjectIdEqualTo(purchaseProjectId);
        List<TTenderMessage> tTenderMessages = tTenderMessageMapper.selectByExample(criteria);
        List<OpeningRecordVO> returnList = new ArrayList<>();
        for (TTenderMessage item : tTenderMessages) {
            OpeningRecordVO openingRecordVO = new OpeningRecordVO();
            BeanUtils.copyProperties(item, openingRecordVO);
            openingRecordVO.setSupplierCompanyId(item.getCompanyId());
            openingRecordVO.setSupplierCompanyName(item.getCompanyName());
            //是否缴纳保证金 是否签到
            BBidOpeningPayCriteria payCriteria = new BBidOpeningPayCriteria();
            BBidOpeningPayCriteria.Criteria subPayCriteria = payCriteria.createCriteria();
            subPayCriteria.andBidIdEqualTo(item.getBidsId());
            subPayCriteria.andProcurementProjectIdEqualTo(item.getPurchaseProjectId());
            subPayCriteria.andTendererCompanyIdEqualTo(item.getCompanyId());
            subPayCriteria.andTendererCompanyNameEqualTo(item.getCompanyName());

        }
        return null;
    }
}
