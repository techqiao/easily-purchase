package com.epc.tendering.service.service.bid.impl;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.domain.supplier.TSupplierDetailInfo;
import com.epc.tendering.service.domain.supplier.TSupplierDetailInfoCriteria;
import com.epc.tendering.service.mapper.bid.*;
import com.epc.tendering.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.tendering.service.service.bid.BidAnnouncementService;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.handle.HandleLetterTenderMemo;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderSubVO;
import com.epc.web.facade.terdering.bid.vo.LetterTenderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 唱标业务
 * @Author: linzhixiang
 * @Date:
 */ 
@Service
public class TBidAnnouncementServiceImpl implements BidAnnouncementService {
     final static Logger LOGGER=LoggerFactory.getLogger(TBidAnnouncementServiceImpl.class);
    @Autowired
    TBidAnnouncementMapper tBidAnnouncementMapper;
    @Autowired
    TOpeningRecordMapper tOpeningRecordMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TTenderMessageMapper tTenderMessageMapper;
    @Autowired
    TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private LetterOfTenderMapper letterOfTenderMapper;
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;

    /**
     * 查询唱标记录路径
     * @return
     */
    @Override
    public Result<String> BidAnnouncementDetail(Long bidId){
        TBidAnnouncementCriteria criteria=new TBidAnnouncementCriteria();
        TBidAnnouncementCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidsIdEqualTo(bidId);
        List<TBidAnnouncement> entity= tBidAnnouncementMapper.selectByExample(criteria);
        if(!CollectionUtils.isEmpty(entity)){
            return  Result.success(entity.get(0).getFilePath());
        }else  {
            return Result.success(null);
        }
    }

    @Override
    public Result<List<LetterTenderSubVO>> getLetterTenderList(Long procurementProjectId) {
        List<LetterTenderSubVO> returnList = new ArrayList<>();
        List<Long> bidsIdList = tPurchaseProjectBidsMapper.getBidsIdList(procurementProjectId);
        for (Long bidsId : bidsIdList) {
            LetterTenderSubVO letterTenderSubVO = new LetterTenderSubVO();
            List<LetterTenderVO> letterTenderVOList = new ArrayList<>();
            LetterOfTenderCriteria criteria = new LetterOfTenderCriteria();
            criteria.createCriteria().andBidsIdEqualTo(bidsId).andProcurementProjectIdEqualTo(procurementProjectId);
            List<LetterOfTender> tenderList = letterOfTenderMapper.selectByExample(criteria);
            for (LetterOfTender letterOfTender : tenderList) {
                LetterTenderVO letterTenderVO = new LetterTenderVO();
                BeanUtils.copyProperties(letterOfTender, letterTenderVO);
                letterTenderVOList.add(letterTenderVO);
            }
            letterTenderSubVO.setBidsId(bidsId);
            letterTenderSubVO.setLetterTenderVOList(letterTenderVOList);
            returnList.add(letterTenderSubVO);
        }
        return Result.success(returnList);
    }

    @Override
    public Result<Boolean> insertLetterTenderMemo(HandleLetterTenderMemo handleLetterTenderMemo) {
        LetterOfTender letterOfTender = new LetterOfTender();
        letterOfTender.setId(handleLetterTenderMemo.getId());
        letterOfTender.setMemo(handleLetterTenderMemo.getMemo());
        return Result.success(letterOfTenderMapper.updateByPrimaryKeyWithBLOBs(letterOfTender) > 0);
    }

    /**
     * 新增一条唱标记录
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertBidAnnouncement(HandleBidAnnouncement handleBidAnnouncement){
        TBidAnnouncement entity =new TBidAnnouncement();
        BeanUtils.copyProperties(handleBidAnnouncement,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
          try{
              tBidAnnouncementMapper.insertSelective(entity);
          }catch (Exception e){
              LOGGER.error("insertBidAnnouncement_"+entity.toString()+"_"+e.getMessage(),e);
              TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
              return Result.error("插入失败");
          }
          return Result.success(true);
    }


    /**
     * 公开供应商投标附录
     * @return
     */
    @Override
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(Long bidId) {
        if(bidId==null){
            return Result.error("bidId is not null");
        }
        TOpeningRecordCriteria criteria=new TOpeningRecordCriteria();
        TOpeningRecordCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidsIdEqualTo(bidId);
        cubCriteria.andStatusEqualTo(Const.OPEN_STATUS.NORMA);
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<TOpeningRecord> resultList=tOpeningRecordMapper.selectByExample(criteria);
        List<BidAnnouncementVO> voList=new ArrayList<>();
        for(TOpeningRecord entity:resultList){
            BidAnnouncementVO vo= new BidAnnouncementVO();
            TSupplierDetailInfoCriteria newCriteria=new TSupplierDetailInfoCriteria();
            TSupplierDetailInfoCriteria.Criteria infoCriteria=newCriteria.createCriteria();
            infoCriteria.andSupplierIdEqualTo(entity.getSupplierCompanyId());
            infoCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
            List<TSupplierDetailInfo> detailList=tSupplierDetailInfoMapper.selectByExample(newCriteria);
            if(detailList.size()==0){
                LOGGER.error("queryBidAnnouncement 查无此供应商");
                return Result.error("queryBidAnnouncement 查无此供应商");
            }else{
                vo.setCompanyId(entity.getSupplierCompanyId());
                vo.setCompanyName(detailList.get(0).getCompanyName());
            }
            TTenderMessageCriteria tcriteria=new TTenderMessageCriteria();
            TTenderMessageCriteria.Criteria cubTcriteria=tcriteria.createCriteria();
            cubTcriteria.andBidsIdEqualTo(bidId);
            cubTcriteria.andCompanyIdEqualTo(entity.getSupplierCompanyId());
            List<TTenderMessage> tenderList=tTenderMessageMapper.selectByExample(tcriteria);
            if(tenderList.size()==0){
                LOGGER.error("queryBidAnnouncement 无招标附件");
                return Result.error("queryBidAnnouncement_"+detailList.get(0).toString()+"_无招标附件");
            }else{
                vo.setBidAppendix(tenderList.get(0).getBidAppendix());
            }
            voList.add(vo);
        }
        return Result.success(voList);
    }
}
