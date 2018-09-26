package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.domain.pretrial.TPretrialMessage;
import com.epc.tendering.service.mapper.bid.*;
import com.epc.tendering.service.mapper.pretrial.TPretrialMessageMapper;
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
    @Autowired
    private TSupplierSignMapper tSupplierSignMapper;

    @Override
    public Result<Boolean> insertOpeningRecord(HandleOpeningRecord handleOpeningRecord) {
        TOpeningRecord tOpeningRecord = new TOpeningRecord();
        BeanUtils.copyProperties(handleOpeningRecord, tOpeningRecord);
        return Result.success(tOpeningRecordMapper.insertSelective(tOpeningRecord) > 0);
    }

    @Override
    public Result<List<OpeningRecordVO>> getOpeningRecordList(Long purchaseProjectId) {
        final TTenderMessageCriteria criteria = new TTenderMessageCriteria();
        criteria.createCriteria().andPurchaseProjectIdEqualTo(purchaseProjectId);
        List<TTenderMessage> tTenderMessages = tTenderMessageMapper.selectByExample(criteria);
        List<OpeningRecordVO> returnList = new ArrayList<>();
        buildList(tTenderMessages, returnList);
        return Result.success(returnList);
    }

    /**
     * 拼装页面数据
     * @param tTenderMessages
     * @param returnList
     */
    private void buildList(List<TTenderMessage> tTenderMessages, List<OpeningRecordVO> returnList) {
        for (TTenderMessage item : tTenderMessages) {
            OpeningRecordVO openingRecordVO = new OpeningRecordVO();
            BeanUtils.copyProperties(item, openingRecordVO);
            openingRecordVO.setSupplierCompanyId(item.getCompanyId());
            openingRecordVO.setSupplierCompanyName(item.getCompanyName());
            BBidOpeningPayCriteria payCriteria = new BBidOpeningPayCriteria();
            BBidOpeningPayCriteria.Criteria subPayCriteria = payCriteria.createCriteria();
            subPayCriteria.andBidIdEqualTo(item.getBidsId());
            subPayCriteria.andProcurementProjectIdEqualTo(item.getPurchaseProjectId());
            subPayCriteria.andTendererCompanyIdEqualTo(item.getCompanyId());
            subPayCriteria.andTendererCompanyNameEqualTo(item.getCompanyName());
            if(bBidOpeningPayMapper.countByExample(payCriteria) > 0){
                //是否缴纳保证金
                openingRecordVO.setIsPayBond(Const.IS_OK.IS_OK);
            }
            final TSupplierSignCriteria signCriteria = new TSupplierSignCriteria();
            final TSupplierSignCriteria.Criteria subSignCriteria = signCriteria.createCriteria();
            subSignCriteria.andCompanyIdEqualTo(item.getCompanyId());
            subSignCriteria.andCompanyNameEqualTo(item.getCompanyName());
            subSignCriteria.andProcurementProjectIdEqualTo(item.getPurchaseProjectId());
            subSignCriteria.andBidsIdEqualTo(item.getBidsId());
            if(tSupplierSignMapper.countByExample(signCriteria)>0){
                //是否签到
                openingRecordVO.setIsSign(Const.IS_OK.IS_OK);
            }
            //关联委托人信息表主键
            openingRecordVO.setTenderMessageId(item.getId());
            returnList.add(openingRecordVO);
        }
    }
}
