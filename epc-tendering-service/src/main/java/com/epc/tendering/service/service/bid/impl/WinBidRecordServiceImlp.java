package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBids;
import com.epc.tendering.service.domain.bid.TPurchaseProjectBidsCriteria;
import com.epc.tendering.service.domain.bid.TWinBidNominate;
import com.epc.tendering.service.domain.bid.TWinBidNominateCriteria;
import com.epc.tendering.service.domain.winBid.TWinBid;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.mapper.bid.TWinBidNominateMapper;
import com.epc.tendering.service.mapper.winBid.TWinBidMapper;
import com.epc.tendering.service.service.bid.WinBidRecordService;
import com.epc.web.facade.bidding.handle.HandleWinBidding;
import com.epc.web.facade.bidding.vo.NominateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
/**
* @Description:  中标公示
* @Author: linzhixiang
* @Date: 2018/9/27
*/
@Service
public class WinBidRecordServiceImlp implements WinBidRecordService {
    final static Logger LOGGER=LoggerFactory.getLogger(WinBidRecordServiceImlp.class);

    @Autowired
    TWinBidNominateMapper tWinBidNominateMapper;
    @Autowired
    TWinBidMapper tWinBidMapper;
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;

    /**
     * 获取采购项目下各标段的中标公示记录
     * @param procurementProjectId
     * @return
     */
    @Override
    public Result<List<NominateVO>> getTWinBidNominated(Long procurementProjectId) {
        TPurchaseProjectBidsCriteria criteria= new TPurchaseProjectBidsCriteria();
        TPurchaseProjectBidsCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(procurementProjectId);
        //获取标段列表
        List<TPurchaseProjectBids> result= tPurchaseProjectBidsMapper.selectByExample(criteria);
        NominateVO vo=new NominateVO();
        List<NominateVO> voList=new ArrayList<>();
        for(TPurchaseProjectBids entity:result){
            TWinBidNominateCriteria criteria1=new TWinBidNominateCriteria();
            TWinBidNominateCriteria.Criteria cubCriteria1=criteria1.createCriteria();
            cubCriteria1.andBidIdEqualTo(entity.getId());
            //根据标段获取中标公示列表
            List<TWinBidNominate> newList=tWinBidNominateMapper.selectByExample(criteria1);
            if(!CollectionUtils.isEmpty(newList)){
                TWinBidNominate TWinBidNominate=newList.get(0);
                BeanUtils.copyProperties(TWinBidNominate,vo);
                voList.add(vo);
            }
        }
        return  Result.success(voList);
    }

    /**
     * 确认中标人和上传中标通知书
     * @param dtoList
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> updateTWinBidNominated(List<HandleWinBidding> dtoList){
        for(HandleWinBidding dto:dtoList){
            TWinBid entity=new TWinBid();
            TWinBidNominate nominate= tWinBidNominateMapper.selectByPrimaryKey(dto.getId());
            entity.setSupplierId(dto.getSupplierId());
            entity.setFilePath(dto.getFilePath());
            entity.setProcessStatus(AnnouncementProcessStatusEnum.NOT_SUBMIT.getCode());
            entity.setProjectName(nominate.getProjectName());
            entity.setProjectCode(nominate.getProjectCode());
            entity.setBidName(nominate.getBidName());
            entity.setBidCode(nominate.getBidCode());
            entity.setBidId(nominate.getBidId());
            try{
                tWinBidMapper.insertSelective(entity);
            }catch (Exception e){
                LOGGER.error("updateTWinBidNominated_"+entity.toString()+"_"+e.getMessage(),e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return  Result.error();
            }
        }
        return  Result.success(true);
    }
}
