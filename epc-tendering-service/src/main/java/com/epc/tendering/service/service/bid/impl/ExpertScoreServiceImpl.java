package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.mapper.bid.*;
import com.epc.tendering.service.service.bid.ExpertScoreService;
import com.epc.web.facade.bidding.handle.HandleScoreReport;
import com.epc.web.facade.terdering.bid.handle.HandleExpertScore;
import com.epc.web.facade.terdering.bid.vo.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-27 10:08
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExpertScoreServiceImpl implements ExpertScoreService {
    private static final Logger LOGGER=LoggerFactory.getLogger(ExpertScoreServiceImpl.class);
    @Autowired
    private BExpertScoreMapper bExpertScoreMapper;
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    private TOpeningRecordMapper tOpeningRecordMapper;
    @Autowired
    TTenderMessageMapper  tTenderMessageMapper;
    @Autowired
    BExpertScoreReportMapper bExpertScoreReportMapper;

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


    /**
     * 查看评标报告
     * @param bidId
     * @return
     */
    @Override
    public Result<ScoreAndPathVO> queryExpertScore(Long bidId) {
        BExpertScoreCriteria criteria=new BExpertScoreCriteria();
        BExpertScoreCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidsIdEqualTo(bidId);
        //查询评分报告记录
        List<BExpertScore> result=bExpertScoreMapper.selectByExample(criteria);
        List<ExpertScoreVO> voList=new ArrayList<>();
        List<FilePathVO> fileList=new ArrayList<>();
        ScoreAndPathVO newVO=new ScoreAndPathVO();
        for(BExpertScore entity:result){
            ExpertScoreVO vo=new ExpertScoreVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
            TTenderMessageCriteria criteria1=new TTenderMessageCriteria();
            TTenderMessageCriteria.Criteria cubCriteria1=criteria1.createCriteria();
            cubCriteria1.andCompanyIdEqualTo(entity.getSupplierId());
            cubCriteria1.andBidsIdEqualTo(bidId);
            //根据供应商Id 查询投标附件记录
            List<TTenderMessage> newList=tTenderMessageMapper.selectByExample(criteria1);
            if(!CollectionUtils.isEmpty(newList)){
                FilePathVO fifo=new FilePathVO();
                BeanUtils.copyProperties(newList.get(0),fifo);
                fileList.add(fifo);
            }
        }
        newVO.setScoreList(voList);
        newVO.setFileList(fileList);
        return  Result.success(newVO);
    }


    /**
     * 撰写评分报告
     * @param handleScore
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createExpertScoreReport(HandleScoreReport handleScore) {
        BExpertScoreReport entity=new BExpertScoreReport();
        BeanUtils.copyProperties(handleScore,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        try{
            bExpertScoreReportMapper.insertSelective(entity);
        }catch (Exception e){
            LOGGER.error("createExpertScoreReport_"+entity.toString()+"_"+e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("插入失败");
        }
        return Result.success(true);
    }
}
