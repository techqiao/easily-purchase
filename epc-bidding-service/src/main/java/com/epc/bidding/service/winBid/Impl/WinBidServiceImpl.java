package com.epc.bidding.service.winBid.Impl;


import com.epc.bidding.domain.bidding.TWinBid;
import com.epc.bidding.domain.bidding.TWinBidCriteria;
import com.epc.bidding.mapper.bidding.TWinBidMapper;
import com.epc.bidding.service.winBid.WinBidService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        cubCriteria.andProjectIdNotEqualTo(dto.getProjectId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        cubCriteria.andSupplierIdEqualTo(dto.getSupplierId());
        criteria.setOrderByClause(" bid_id desc");
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

}
