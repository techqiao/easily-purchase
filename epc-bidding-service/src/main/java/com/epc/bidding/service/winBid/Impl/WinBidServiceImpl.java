package com.epc.bidding.service.winBid.Impl;


import com.epc.bidding.domain.bidding.*;
import com.epc.bidding.mapper.bidding.*;
import com.epc.bidding.service.winBid.WinBidService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
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
     * 获取中标通知书列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<WinBidLetterVO>> getWinBidLetter(QueryWinBidLetterDTO dto){
        TWinBidCriteria criteria=new TWinBidCriteria();
        TWinBidCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidIdEqualTo(dto.getBidId());
        cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        cubCriteria.andProjectIdEqualTo(dto.getProjectId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        cubCriteria.andSupplierIdEqualTo(dto.getSupplierId());
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
     * 查询中标公示记录
     * @param bidId
     * @return
     */

    @Override
    public Result<TWinBidNominateVO> getTWinBidNominate(Long bidId){
        TWinBidNominateCriteria criteria=new TWinBidNominateCriteria();
        TWinBidNominateCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidIdEqualTo(bidId);
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        TWinBidNominateVO vo=new TWinBidNominateVO();
        //查询中标公示提名表
        List<TWinBidNominate> result=tWinBidNominateMapper.selectByExample(criteria);
        if(!CollectionUtils.isEmpty(result)){
            TWinBidNominate entity =result.get(0);
            BeanUtils.copyProperties(entity,vo);
            //查询采购项目记录
            TPurchaseProjectBasicInfo purchaseProjectBasicInfo= tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(entity.getPurchaseProjectId());
            vo.setProcurementProjectName(purchaseProjectBasicInfo.getPurchaseProjectName());
            vo.setProcurementProjectCode(purchaseProjectBasicInfo.getPurchaseProjectCode());
            vo.setPurchaseType(purchaseProjectBasicInfo.getPurchaseType());
            vo.setPurchaseMode(purchaseProjectBasicInfo.getPurchaseMode());
        }
        return Result.success(vo);
    }

    /**
     * 插入中标公示表
     * @param handleWinBid
     * @return
     */
    public Result<Boolean> insertTWinBidNominate(HandleWinBid handleWinBid) {
            TWinBidNominate entity=new TWinBidNominate();
            //查询项目记录
            TProjectBasicInfo tProjectBasicInfo = tProjectBasicInfoMapper.selectByPrimaryKey(handleWinBid.getProjectId());
            entity.(tPurchaserDetailInfoMapper.selectName(tProjectBasicInfo.getPurchaserId()));
            //查询采购项目记录
            TPurchaseProjectBasicInfo purchaseProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(handleWinBid.getProcurementProjectId());
            //判断是否委托代理机构(0否，1是)
            vo.setIsPowerAgency(purchaseProjectBasicInfo.getIsOtherAgency());
            //采购项目人员参与人
            List<TPurchaseProjectParticipant> participantList = tPurchaseProjectParticipantMapper.selectPersonList(handleWinBid.getProcurementProjectId());
            if (!CollectionUtils.isEmpty(participantList)) {
                //获取采购项目经办人
                for (TPurchaseProjectParticipant pantEntity : participantList) {
                    List<TPurchaseProjectParticipantPermission> permissions = tPurchaseProjectParticipantPermissionMapper.getAgencyInfo(pantEntity.getId());
                    if (!CollectionUtils.isEmpty(permissions)) {
                        vo.setAgencyCellPhone(pantEntity.getUserPhone());
                        vo.setAgencyName(pantEntity.getUserName());
                        vo.setAgencyCompanyname(pantEntity.getAgencyName());
                        break;
                    }
                }
            }

            //查询标段
            TPurchaseProjectBids purchaseProjectBids = tPurchaseProjectBidsMapper.selectByPrimaryKey(entity.getBidId());


    }
}
