package com.epc.bidding.service.schedule.impl;

import com.epc.bidding.domain.TProjectProcedure;
import com.epc.bidding.domain.TProjectProcedureCriteria;
import com.epc.bidding.mapper.TProjectProcedureMapper;
import com.epc.bidding.service.schedule.ScheduleService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.query.schedule.HandleProjectSchedule;
import com.epc.web.facade.bidding.query.schedule.QueryProjectSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

@Autowired
TProjectProcedureMapper tProjectBidProcedureMapper;
    /**
     * 根据 purchaseProjectId和 用户类型 判断标段
     * @param dto
     * @return
     */
    @Override
    public Result<String> queryProjectSchedule(QueryProjectSchedule dto){
        TProjectProcedureCriteria criteria=new TProjectProcedureCriteria();
        TProjectProcedureCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andPurchaseProjectIdEqualTo(dto.getPurchaseProjectId());
        cubCriteria.andOperateTypeEqualTo("supplier");
        criteria.setOrderByClause("create_at desc");
        List<TProjectProcedure> result=tProjectBidProcedureMapper.selectByExample(criteria);
        if(result.size()>0){
            return  Result.success(result.get(0).getProcedureCode());
        }else{
            return Result.success(null);
        }
    }

    /**
     * 环节插入
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor =Exception.class )
    public Result<Boolean> insertProjectSchedule(HandleProjectSchedule dto) {
        TProjectProcedure entity = new TProjectProcedure();
        BeanUtils.copyProperties(dto, entity);
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        try {
            tProjectBidProcedureMapper.insertSelective(entity);
        } catch (Exception e) {
            LOGGER.error("insertProjectSchedule_" + entity.toString() + "_" + e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error();
        }
        return Result.success(true);
    }

}
