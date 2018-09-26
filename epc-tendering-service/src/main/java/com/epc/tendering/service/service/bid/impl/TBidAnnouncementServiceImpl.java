package com.epc.tendering.service.service.bid.impl;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.mapper.bid.TBidAnnouncementMapper;
import com.epc.tendering.service.mapper.bid.TOpeningRecordMapper;
import com.epc.tendering.service.mapper.bid.TPurchaserDetailInfoMapper;
import com.epc.tendering.service.mapper.bid.TTenderMessageMapper;
import com.epc.tendering.service.service.bid.TBidAnnouncementService;
import com.epc.web.facade.terdering.bid.handle.HandleBidAnnouncement;
import com.epc.web.facade.terdering.bid.query.QueryBidAnnouncement;
import com.epc.web.facade.terdering.bid.vo.BidAnnouncementVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TBidAnnouncementServiceImpl implements TBidAnnouncementService {
     final static Logger LOGGER=LoggerFactory.getLogger(TBidAnnouncementServiceImpl.class);
    @Autowired
    TBidAnnouncementMapper tBidAnnouncementMapper;
    @Autowired
    TOpeningRecordMapper tOpeningRecordMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;
    @Autowired
    TTenderMessageMapper tTenderMessageMapper;

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
          try{
              tBidAnnouncementMapper.insertSelective(entity);
          }catch (Exception e){
              LOGGER.error("insertBidAnnouncement 插入失败");
              TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
          }
          return Result.success(true);
    }


    @Transactional(rollbackFor = Exception.class)
    public Result<List<BidAnnouncementVO>> queryBidAnnouncement(QueryBidAnnouncement queryBidAnnouncement) {
        TOpeningRecordCriteria criteria=new TOpeningRecordCriteria();
        TOpeningRecordCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidsIdEqualTo(queryBidAnnouncement.getBidId());
        cubCriteria.andStatusEqualTo(Const.OPEN_STATUS.NORMA);
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<TOpeningRecord> resultList=tOpeningRecordMapper.selectByExample(criteria);
        List<BidAnnouncementVO> voList=new ArrayList<>();
        for(TOpeningRecord entity:resultList){
            BidAnnouncementVO vo= new BidAnnouncementVO();
            TPurchaserDetailInfoCriteria newCriteria=new TPurchaserDetailInfoCriteria();
            TPurchaserDetailInfoCriteria.Criteria infoCriteria=newCriteria.createCriteria();
            infoCriteria.andPurchaserIdEqualTo(entity.getSupplierCompanyId());
            infoCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
            List<TPurchaserDetailInfo> detailList=tPurchaserDetailInfoMapper.selectByExample(newCriteria);
            if(detailList.size()==0){
                LOGGER.error("queryBidAnnouncement 查无此供应商");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }else{
                vo.setCompanyId(entity.getSupplierCompanyId());
                vo.setCompanyName(detailList.get(0).getCompanyName());
            }
            TTenderMessageCriteria tcriteria1=new TTenderMessageCriteria();
            TTenderMessageCriteria.Criteria cubTcriteria1=tcriteria1.createCriteria();
            cubTcriteria1.andBidIdEqualTo(queryBidAnnouncement.getBidId());
            cubTcriteria1.andCompanyIdEqualTo(entity.getSupplierCompanyId());
            List<TTenderMessage> tenderList=tTenderMessageMapper.selectByExample(tcriteria1);
            if(tenderList.size()==0){
                LOGGER.error("queryBidAnnouncement 无招标附件");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }else{
                vo.setBid_appendix(tenderList.get(0).getBidAppendix());
            }
            voList.add(vo);
        }
        return Result.success(voList);
    }
}
