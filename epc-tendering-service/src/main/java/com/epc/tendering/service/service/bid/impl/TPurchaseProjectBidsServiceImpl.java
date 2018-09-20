package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBids;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBidsCriteria;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.service.bid.TPurchaseProjectBidsService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsBasicInfo;
import com.epc.web.facade.terdering.bid.query.QueryBidsDTO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoSubVO;
import com.epc.web.facade.terdering.bid.vo.BidsBasicInfoVO;
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
 * <p>Date : 2018-09-19 11:30
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TPurchaseProjectBidsServiceImpl implements TPurchaseProjectBidsService {
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;


    @Override
    public Result<Boolean> handleBidsBasicInfo(HandleBidsBasicInfo handleBidsBasicInfo) {
        TPurchaseProjectBids pojo = new TPurchaseProjectBids();
        BeanUtils.copyProperties(handleBidsBasicInfo, pojo);
        try {
            if(pojo.getId() == null){
                pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                pojo.setCreateAt(new Date());
                pojo.setUpdateAt(new Date());
                return Result.success(tPurchaseProjectBidsMapper.insertSelective(pojo) > 0);
            }else {
                return Result.success(tPurchaseProjectBidsMapper.updateByPrimaryKeySelective(pojo) > 0);
            }
        }catch (BusinessException e){
            return Result.error(ErrorMessagesEnum.FAILURE);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @Override
    public Result<BidsBasicInfoSubVO> getBidsDetailInfo(Long bidId) {
        TPurchaseProjectBids tPurchaseProjectBids = tPurchaseProjectBidsMapper.selectByPrimaryKey(bidId);
        BidsBasicInfoSubVO returnPojo = new BidsBasicInfoSubVO();
        BeanUtils.copyProperties(tPurchaseProjectBids,returnPojo);
        return Result.success(returnPojo);
    }

    @Override
    public Result<List<BidsBasicInfoVO>> getBidsList(QueryBidsDTO queryBidsDTO) {
        final TPurchaseProjectBidsCriteria criteria = new TPurchaseProjectBidsCriteria();
        final TPurchaseProjectBidsCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andPurchaseProjectIdEqualTo(queryBidsDTO.getPurchaseProjectId());
        List<BidsBasicInfoVO> returnList = new ArrayList<>();
        List<TPurchaseProjectBids> bidsList = tPurchaseProjectBidsMapper.selectByExampleWithRowbounds(criteria, queryBidsDTO.getRowBounds());
        bidsList.forEach(item -> {
            BidsBasicInfoVO pojo = new BidsBasicInfoVO();
            BeanUtils.copyProperties(item, pojo);
            returnList.add(pojo);
        });
        return Result.success(returnList);
    }
}
