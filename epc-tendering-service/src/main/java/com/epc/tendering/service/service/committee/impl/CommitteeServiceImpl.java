package com.epc.tendering.service.service.committee.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.committee.BAssessmentCommittee;
import com.epc.tendering.service.domain.committee.BAssessmentCommitteeBid;
import com.epc.tendering.service.domain.committee.BAssessmentCommitteeExpert;
import com.epc.tendering.service.domain.expert.TExpertBasicInfo;
import com.epc.tendering.service.domain.expert.TExpertBasicInfoCriteria;
import com.epc.tendering.service.mapper.committee.BAssessmentCommitteeBidMapper;
import com.epc.tendering.service.mapper.committee.BAssessmentCommitteeExpertMapper;
import com.epc.tendering.service.mapper.committee.BAssessmentCommitteeMapper;
import com.epc.tendering.service.mapper.expert.TExpertBasicInfoMapper;
import com.epc.tendering.service.service.committee.CommitteeService;
import com.epc.web.facade.terdering.committee.dto.BidDTO;
import com.epc.web.facade.terdering.committee.dto.ExpertDTO;
import com.epc.web.facade.terdering.committee.handle.HandleCommittee;
import com.epc.web.facade.terdering.committee.query.QueryExtractExpertList;
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
import java.util.Random;

@Service
public class CommitteeServiceImpl implements CommitteeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommitteeServiceImpl.class);

    @Autowired
    BAssessmentCommitteeMapper bAssessmentCommitteeMapper;
    @Autowired
    BAssessmentCommitteeBidMapper bAssessmentCommitteeBidMapper;
    @Autowired
    BAssessmentCommitteeExpertMapper bAssessmentCommitteeExpertMapper;
    @Autowired
    TExpertBasicInfoMapper tExpertBasicInfoMapper;

    /**
     * 组建评委员会信息
     * @param dto
     * @return
     */
    @Override
    public Result<Long> createCommittee(HandleCommittee dto){
        BAssessmentCommittee committee=new BAssessmentCommittee();
        BeanUtils.copyProperties(dto,committee);
        committee.setProcessStatus(Const.PROCESS_STATE.SAVE);
        committee.setCreateAt(new Date());
        committee.setUpdateAt(new Date());
        committee.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try{
            bAssessmentCommitteeMapper.insertSelective(committee);
        }catch (Exception e){
            LOGGER.error("createCommittee"+committee.toString()+e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error();
        }
        return Result.success(committee.getId());
    }


    /**
     * 根据委员会信息Id组建专家
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> createBAssessmentCommittee(QueryExtractExpertList dto){

        /** 组建评委员--标段对应专专业人数 */
        List<BidDTO> bidList=dto.getBidDTOList();
        List<ExpertDTO> expertList=dto.getExpertDTOList();
        //获取要抽取的标段列表
        for(BidDTO bid:bidList){
            for(ExpertDTO expert:expertList){
                BAssessmentCommitteeBid committeeBid =new BAssessmentCommitteeBid();
                BeanUtils.copyProperties(bid,committeeBid);
                BeanUtils.copyProperties(expert,committeeBid);
                committeeBid.setCommitteeId(dto.getCommitteeId());
                committeeBid.setCreateAt(new Date());
                committeeBid.setUpdateAt(new Date());
                committeeBid.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                try{
                    bAssessmentCommitteeBidMapper.insertSelective(committeeBid) ;
                }catch (Exception e){
                    LOGGER.error("bAssessmentCommitteeBid_"+committeeBid.toString()+e.getMessage(),e);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }

                //专业人数--专家列表
                TExpertBasicInfoCriteria criteria=new TExpertBasicInfoCriteria();
                TExpertBasicInfoCriteria.Criteria cubCriteria=criteria.createCriteria();
                cubCriteria.andProfessionEqualTo(expert.getProfessionalName());
                cubCriteria.andLevelEqualTo(expert.getProfessionalName());
                cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
                List<TExpertBasicInfo> resultList=tExpertBasicInfoMapper.selectByExample(criteria);
                List<TExpertBasicInfo> padomList = getSubStringByRadom(resultList,expert.getProfessionalNumber());
                for(TExpertBasicInfo entity:padomList){
                    BAssessmentCommitteeExpert bAssessmentCommitteeExpert=new BAssessmentCommitteeExpert();
                    bAssessmentCommitteeExpert.setCommitteeBidId(committeeBid.getId());
                    bAssessmentCommitteeExpert.setExpertId(entity.getId());
                    bAssessmentCommitteeExpert.setExpertName(entity.getName());
                    bAssessmentCommitteeExpert.setOperateId(dto.getOperateId());
                    bAssessmentCommitteeExpert.setCreateAt(new Date());
                    bAssessmentCommitteeExpert.setUpdateAt(new Date());
                    bAssessmentCommitteeExpert.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    try{
                        bAssessmentCommitteeExpertMapper.insertSelective(bAssessmentCommitteeExpert);
                    }catch (Exception e){
                        LOGGER.error("bAssessmentCommitteeExpert 插入失败");
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                }

            }
        }
        return Result.success(true);
    }

    /**
     *     随机从List 里面挑选 count个对象
     */
    public List<TExpertBasicInfo> getSubStringByRadom(List<TExpertBasicInfo> list,int count){
        List backList = null;
        backList = new ArrayList<TExpertBasicInfo>();
        Random random = new Random();
        int backSum = 0;
        if (list.size() >= count) {
            backSum = count;
        }else {
            backSum = list.size();
        }
        for (int i = 0; i < backSum; i++) {
//			随机数的范围为0-list.size()-1
            int target = random.nextInt(list.size());
            backList.add(list.get(target));
            list.remove(target);
        }
        return backList;
    }

}

