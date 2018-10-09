package com.epc.bidding.service.winBid.Impl;

import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.winBid.WinBidService;
import com.epc.common.Result;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.common.constants.Const;
import com.epc.common.constants.ParticipantPermissionEnum;
import com.epc.common.constants.ProcessStatusEnum;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.handle.HandleWinBidFilePath;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
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
* @Description:  中标公告业务
* @Author: linzhixiang
* @Date: 2018/9/22
*/
@Service
public class WinBidServiceImpl implements WinBidService {


    @Autowired
    TWinBidMapper tWinBidMapper;
    @Autowired
    TWinBidNominateMapper tWinBidNominateMapper;
    @Autowired
    TProjectBasicInfoMapper tProjectBasicInfoMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    TPurchaseProjectParticipantMapper tPurchaseProjectParticipantMapper;
    @Autowired
    TPurchaseProjectParticipantPermissionMapper tPurchaseProjectParticipantPermissionMapper;
    @Autowired
    TPurchaserDetailInfoMapper tPurchaserDetailInfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(WinBidServiceImpl.class);

    /**
     * 获取中标通知书列表（采购项目全部标段 / 单一标段）
     * @param dto
     * @return
     */
    @Override
    public Result<List<WinBidLetterVO>> getWinBidLetter(QueryWinBidLetterDTO dto){
        TWinBidCriteria criteria=new TWinBidCriteria();
        TWinBidCriteria.Criteria cubCriteria=criteria.createCriteria();
        if(dto.getBidId()!=null){
            cubCriteria.andBidIdEqualTo(dto.getBidId());
        }
        if(dto.getProcurementProjectId()!=null){
            cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        }
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        cubCriteria.andSupplierIdEqualTo(dto.getSupplierId());
        cubCriteria.andProcessStatusEqualTo(ProcessStatusEnum.RELEASED.getCode());
        List<TWinBid> resultList= tWinBidMapper.selectByExample(criteria);
        if(resultList.size()==0){
            return Result.success(null);
        }
        List<WinBidLetterVO> voList=new ArrayList<>();
        for(TWinBid entity:resultList){
            WinBidLetterVO vo=new WinBidLetterVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
        }
        return Result.success(voList);
    }

    /**
     * 查询中标公示列表
     * @param purchaseProjectId
     * @return
     */

    @Override
    public Result<List<TWinBidNominateVO>> getTWinBidNominate(Long purchaseProjectId){
        if(purchaseProjectId==null){
            Result.error("purchaseProjectId is not null");
        }
        TWinBidNominateCriteria criteria=new TWinBidNominateCriteria();
        TWinBidNominateCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(purchaseProjectId);
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //大于开始时间
        cubCriteria.andOpenStartLessThanOrEqualTo(new Date());
        //小于结束时间
        cubCriteria.andOpenEndGreaterThan(new Date());
        List<TWinBidNominateVO> voList=new ArrayList<>();
        //查询中标公示提名表
        List<TWinBidNominate> result=tWinBidNominateMapper.selectByExample(criteria);
        for(TWinBidNominate entity:result ){
            TWinBidNominateVO vo=new TWinBidNominateVO();
            if(!CollectionUtils.isEmpty(result)) {
                BeanUtils.copyProperties(entity,vo);
                //查询采购项目记录
                TPurchaseProjectBasicInfo purchaseProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(purchaseProjectId);
                vo.setProcurementProjectName(purchaseProjectBasicInfo.getPurchaseProjectName());
                vo.setProcurementProjectCode(purchaseProjectBasicInfo.getPurchaseProjectCode());
                vo.setPurchaseType(purchaseProjectBasicInfo.getPurchaseType());
                vo.setPurchaseMode(purchaseProjectBasicInfo.getPurchaseMode());
                voList.add(vo);
            }
        }
        return Result.success(voList);
    }

    /**
     * 插入中标公示表
     * @param handleWinBid
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertTWinBidNominate(HandleWinBid handleWinBid) {
            TWinBidNominate entity=new TWinBidNominate();
            //查询项目记录
            TProjectBasicInfo tProjectBasicInfo = tProjectBasicInfoMapper.selectByPrimaryKey(handleWinBid.getProjectId());
            entity.setPurchaserName(tPurchaserDetailInfoMapper.selectName(tProjectBasicInfo.getPurchaserId()));
            BeanUtils.copyProperties(handleWinBid,entity);
            entity.setProjectCode(tProjectBasicInfo.getProjectCode());
            entity.setProjectName(tProjectBasicInfo.getProjectName());
            entity.setCreateAt(new Date());
            entity.setUpdateAt(new Date());
            entity.setOperateId(handleWinBid.getPurchaserId());
            entity.setProcessStatus(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode());
            entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            //获取标段记录
            TPurchaseProjectBids purchaseProjectBids=tPurchaseProjectBidsMapper.selectByPrimaryKey(entity.getBidId());
            entity.setBidCode(purchaseProjectBids.getBidCode());
            //查询采购项目记录
            TPurchaseProjectBasicInfo purchaseProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(handleWinBid.getProcurementProjectId());
            //判断是否委托代理机构(0否，1是)
            entity.setIsPowerAgency(purchaseProjectBasicInfo.getIsOtherAgency());
            //采购项目人员经办人
            TPurchaseProjectParticipantPermissionCriteria criteria=new TPurchaseProjectParticipantPermissionCriteria();
            TPurchaseProjectParticipantPermissionCriteria.Criteria newCriteria=criteria.createCriteria();
            newCriteria.andPurchaseProjectIdEqualTo(handleWinBid.getProcurementProjectId());
            newCriteria.andParticipantPermissionEqualTo(ParticipantPermissionEnum.AGENT.getCode());
            newCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
            List<TPurchaseProjectParticipantPermission> ppp=tPurchaseProjectParticipantPermissionMapper.selectByExample(criteria);
            if(ppp.size()>0){
                TPurchaseProjectParticipant pp=  tPurchaseProjectParticipantMapper.selectByPrimaryKey(ppp.get(0).getParticipantId());
                entity.setAgencyName(pp.getUserName());
                entity.setAgencyPhone(pp.getUserPhone());
            }
            try {
                tWinBidNominateMapper.insertSelective(entity);
            }catch (Exception e){
                LOGGER.error("insertTWinBidNominate_"+e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error();
            }
            return Result.success(true);
    }

    /**
     * 插入中标公示文件路径
     * @param handleWinBidFilePath
     * @return
     */
    @Override
    @Transactional(rollbackFor =Exception.class)
    public Result<Boolean> insertTWinBidNominateFilePath(HandleWinBidFilePath handleWinBidFilePath){
        if(handleWinBidFilePath.getId()!=null){
            TWinBidNominate entity= tWinBidNominateMapper.selectByPrimaryKey(handleWinBidFilePath.getId());
            entity.setFilePath(handleWinBidFilePath.getFilePath());
            try{
                tWinBidNominateMapper.insertSelective(entity);
            }catch (Exception e){
                LOGGER.error("insertTWinBidNominateFilePath_"+entity.toString()+"_"+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                Result.error("insertTWinBidNominateFilePath insert fail");
            }
            return  Result.success(true);
        }else{
            Result.error("id is not null");
            return  Result.error();
        }
    }

}
