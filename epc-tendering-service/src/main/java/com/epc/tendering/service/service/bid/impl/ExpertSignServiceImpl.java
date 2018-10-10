package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.BExpertSign;
import com.epc.tendering.service.domain.bid.BExpertSignCriteria;
import com.epc.tendering.service.domain.committee.BAssessmentCommitteeExpert;
import com.epc.tendering.service.domain.committee.BAssessmentCommitteeExpertCriteria;
import com.epc.tendering.service.mapper.bid.BExpertSignMapper;
import com.epc.tendering.service.mapper.bid.TPurchaseProjectBidsMapper;
import com.epc.tendering.service.mapper.committee.BAssessmentCommitteeBidMapper;
import com.epc.tendering.service.mapper.committee.BAssessmentCommitteeExpertMapper;
import com.epc.tendering.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.tendering.service.service.bid.ExpertSignService;
import com.epc.web.facade.terdering.bid.handle.HandleExpertSign;
import com.epc.web.facade.terdering.bid.vo.ExpertSignVO;
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
 * <p>Date : 2018-09-26 19:47
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ExpertSignServiceImpl implements ExpertSignService {
    @Autowired
    private BExpertSignMapper bExpertSignMapper;
    @Autowired
    private TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    private BAssessmentCommitteeBidMapper bAssessmentCommitteeBidMapper;
    @Autowired
    private BAssessmentCommitteeExpertMapper bAssessmentCommitteeExpertMapper;
    @Autowired
    private TExpertBasicInfoMapper tExpertBasicInfoMapper;

    @Override
    public Result<Boolean> insertExpertSign(HandleExpertSign handleExpertSign) {
        //通过评标专家电话号 去判断是否是该标段的专家号 过滤
        BExpertSign bExpertSign = new BExpertSign();
        BeanUtils.copyProperties(handleExpertSign, bExpertSign);
        try {
            return Result.success(bExpertSignMapper.insertSelective(bExpertSign) > 0);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Result.error();
    }

    @Override
    public Result<Boolean> handleExpert(HandleExpertSign handleExpertSign) {
        BExpertSign bExpertSign = new BExpertSign();
        BeanUtils.copyProperties(handleExpertSign,bExpertSign);
        try {
            return Result.success(bExpertSignMapper.updateByPrimaryKeySelective(bExpertSign) > 0);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Result.error();

    }

    @Override
    public Result<List<ExpertSignVO>> getExpertList(Long procurementProjectId) {
        List<ExpertSignVO> returnList = new ArrayList<>();
        List<Long> bidsIdList = tPurchaseProjectBidsMapper.getBidsIdList(procurementProjectId);
        for (Long bidsId : bidsIdList) {
            List<Long> committeeBidIdList = bAssessmentCommitteeBidMapper.getCommitteeBidIdList(bidsId);
            for (Long committeeBidId : committeeBidIdList) {
                BAssessmentCommitteeExpertCriteria criteria = new BAssessmentCommitteeExpertCriteria();
                criteria.createCriteria().andCommitteeBidIdEqualTo(committeeBidId);
                List<BAssessmentCommitteeExpert> expertList = bAssessmentCommitteeExpertMapper.selectByExample(criteria);
                for (BAssessmentCommitteeExpert item : expertList) {
                    ExpertSignVO pojo = new ExpertSignVO();
                    pojo.setExpertId(item.getExpertId());
                    pojo.setBidsId(bidsId);
                    pojo.setExpertName(item.getExpertName());
                    pojo.setProcurementProjectId(procurementProjectId);
                    pojo.setExpertPhone(tExpertBasicInfoMapper.getCellPhone(item.getExpertId()));
                    BExpertSignCriteria signCriteria = new BExpertSignCriteria();
                    signCriteria.createCriteria().andBidsIdEqualTo(bidsId).andExpertIdEqualTo(item.getExpertId());
                    if (bExpertSignMapper.countByExample(signCriteria) > 0) {
                        pojo.setIsSign(Const.IS_OK.IS_OK);
                    }else{
                        pojo.setIsSign(Const.IS_OK.NOT_OK);
                    }
                    returnList.add(pojo);
                }
            }
        }
        return Result.success(returnList);
    }
}
