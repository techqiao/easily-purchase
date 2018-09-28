package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.mapper.bid.BExpertScoreMapper;
import com.epc.tendering.service.mapper.bid.TOpeningRecordMapper;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.service.bid.ExpertScoreService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.BidderListVO;
import com.epc.web.facade.terdering.bid.vo.BidderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:08
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExpertScoreServiceImpl implements ExpertScoreService {
    @Autowired
    private BExpertScoreMapper bExpertScoreMapper;
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    private TOpeningRecordMapper tOpeningRecordMapper;

    @Override
    public Result<List<BidderListVO>> getBidderList(Long procurementProjectId) {
        List<Long> bidsIdList = tPurchaseProjectBidsMapper.getBidsIdList(procurementProjectId);
        List<BidderListVO> returnList = new ArrayList<>();
        for (Long bidsId : bidsIdList) {
            BidderListVO bidderListVO = new BidderListVO();
            bidderListVO.setBidsId(bidsId);
            List<BidderVO> list = new ArrayList<>();
            TOpeningRecordCriteria criteria = new TOpeningRecordCriteria();
            criteria.createCriteria().andBidsIdEqualTo(bidsId).andStatusEqualTo(Const.IS_OK.IS_OK);
            List<TOpeningRecord> recordList = tOpeningRecordMapper.selectByExample(criteria);
            for (TOpeningRecord item : recordList) {
                BidderVO bidderVO = new BidderVO();
                bidderVO.setSupplierId(item.getSupplierCompanyId());
                bidderVO.setSupplierCompanyName(item.getSupplierCompanyName());
                BExpertScoreCriteria scoreCriteria = new BExpertScoreCriteria();
                scoreCriteria.createCriteria().andBidsIdEqualTo(bidsId).andSupplierIdEqualTo(item.getSupplierCompanyId());
                if (bExpertScoreMapper.countByExample(scoreCriteria) > 0) {
                    bidderVO.setStatus("already");
                }
                list.add(bidderVO);
            }
            bidderListVO.setBidderVOList(list);
        }
        return Result.success(returnList);
    }

    @Override
    public Result<Boolean> handleExpertScore(HandleExpertScore handleExpertScore) {
        BExpertScore bExpertScore = new BExpertScore();
        BeanUtils.copyProperties(handleExpertScore, bExpertScore);
        try {
            return Result.success(bExpertScoreMapper.insertSelective(bExpertScore) > 0);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Result.error();
    }

}
