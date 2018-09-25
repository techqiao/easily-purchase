package com.epc.bidding.service.winBid.Impl;


import com.epc.bidding.domain.bidding.TWinBid;
import com.epc.bidding.domain.bidding.TWinBidCriteria;
import com.epc.bidding.mapper.bidding.TWinBidMapper;
import com.epc.bidding.service.winBid.WinBidService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidDTO;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.WinBidVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WinBidServiceImpl implements WinBidService {


    @Autowired
    TWinBidMapper tWinBidMapper;

    /**
     * 获取中标公告 列表
     * @param dto
     * @return
     */
    public Result<List<WinBidVO>> getWinBidList(QueryWinBidDTO dto){
        TWinBidCriteria criteria=new TWinBidCriteria();
        TWinBidCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidIdEqualTo(dto.getBidId());
        cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        cubCriteria.andProjectIdNotEqualTo(dto.getProjectId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        criteria.setOrderByClause(" bid_id desc");
        List<TWinBid> resultList= tWinBidMapper.selectByExample(criteria);
        if(resultList.size()==0){
            return Result.success(null);
        }
        List<WinBidVO> voList=new ArrayList<>();
        for(TWinBid entity:resultList){
            WinBidVO vo=new WinBidVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
        }
        return Result.success(voList);
    }





   /* public Result<List<WinBidVO>> getWinBidLetter(QueryWinBidLetterDTO dto){
        TWinBidCriteria criteria=new TWinBidCriteria();
        TWinBidCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andBidIdEqualTo(dto.getBidId());
        cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        cubCriteria.andProjectIdNotEqualTo(dto.getProjectId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        criteria.setOrderByClause(" bid_id desc");
        List<TWinBid> resultList= tWinBidMapper.selectByExample(criteria);

        if(resultList.size()==0){
            return Result.success(null);
        }
        List<WinBidVO> voList=new ArrayList<>();
        for(TWinBid entity:resultList){
            WinBidVO vo=new WinBidVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
        }
        return Result.success(voList);

    }*/



}
