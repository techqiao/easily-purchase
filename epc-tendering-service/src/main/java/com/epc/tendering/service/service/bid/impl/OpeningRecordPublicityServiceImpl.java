package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.tendering.service.domain.bid.TOpeningRecordPublicity;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBegin;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBeginCriteria;
import com.epc.tendering.service.mapper.bid.TOpeningRecordPublicityMapper;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBeginMapper;
import com.epc.tendering.service.service.bid.OpeningRecordPublicityService;
import com.epc.web.facade.terdering.bid.handle.HandOpeningRecordPublicity;
import com.epc.web.facade.terdering.bid.handle.HandlePurchaseProjectBegin;
import com.epc.web.facade.terdering.bid.vo.PurchaseProjectBeginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-26 17:52
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OpeningRecordPublicityServiceImpl implements OpeningRecordPublicityService {

    @Autowired
    private TOpeningRecordPublicityMapper tOpeningRecordPublicityMapper;

    @Autowired
    private TPurchaseProjectBeginMapper tPurchaseProjectBeginMapper;

    @Override
    public Result<Boolean> insertOpeningRecordPublicity(HandOpeningRecordPublicity handOpeningRecordPublicity) {
        if (handOpeningRecordPublicity.getId() == null) {
            TOpeningRecordPublicity tOpeningRecordPublicity = new TOpeningRecordPublicity();
            BeanUtils.copyProperties(handOpeningRecordPublicity, tOpeningRecordPublicity);
            try {
                return Result.success(tOpeningRecordPublicityMapper.insertSelective(tOpeningRecordPublicity) > 0);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        if (handOpeningRecordPublicity.getId() != null) {
            TOpeningRecordPublicity tOpeningRecordPublicity = new TOpeningRecordPublicity();
            BeanUtils.copyProperties(handOpeningRecordPublicity, tOpeningRecordPublicity);
            try {
                return Result.success(tOpeningRecordPublicityMapper.updateByPrimaryKeySelective(tOpeningRecordPublicity) > 0);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

        }
        return Result.error();
    }

    @Override
    public Result<Boolean> insertPurchaseProjectBegin(HandlePurchaseProjectBegin handlePurchaseProjectBegin) {
        TPurchaseProjectBegin tPurchaseProjectBegin = new TPurchaseProjectBegin();
        BeanUtils.copyProperties(handlePurchaseProjectBegin, tPurchaseProjectBegin);
        try {
            return Result.success(tPurchaseProjectBeginMapper.insertSelective(tPurchaseProjectBegin) > 0);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Result.error();
    }

    @Override
    public Result<PurchaseProjectBeginVO> getPurchaseProjectBegin(Long purchaseProjectId) {
        TPurchaseProjectBeginCriteria criteria = new TPurchaseProjectBeginCriteria();
        criteria.createCriteria().andPurchaseProjectIdEqualTo(purchaseProjectId);
        List<TPurchaseProjectBegin> tPurchaseProjectBegins = tPurchaseProjectBeginMapper.selectByExample(criteria);
        if (!CollectionUtils.isEmpty(tPurchaseProjectBegins)) {
            PurchaseProjectBeginVO purchaseProjectBeginVO = new PurchaseProjectBeginVO();
            BeanUtils.copyProperties(tPurchaseProjectBegins.get(0), purchaseProjectBeginVO);
            return Result.success(purchaseProjectBeginVO);
        }
        return Result.success("没有开标确认");
    }
}
