package com.epc.bidding.service.moneyPay.impl;


import com.epc.bidding.domain.bidding.TServiceMoneyPay;
import com.epc.bidding.domain.bidding.TServiceMoneyPayCriteria;
import com.epc.bidding.domain.bidding.TServiceMoneyPayRecord;
import com.epc.bidding.domain.bidding.TServiceMoneyPayRecordCriteria;
import com.epc.bidding.mapper.bidding.TServiceMoneyPayMapper;
import com.epc.bidding.mapper.bidding.TServiceMoneyPayRecordMapper;
import com.epc.bidding.service.moneyPay.MoneyPayService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoneyPayServiceImpl implements MoneyPayService {
    @Autowired
    TServiceMoneyPayMapper tServiceMoneyPayMapper;
    @Autowired
    TServiceMoneyPayRecordMapper tServiceMoneyPayRecordMapper;

    /**
     * 获取 缴纳投标保证金列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<MoneyPayVO>> getMoneyPayList(QueryMoneyPayDTO dto){
        TServiceMoneyPayCriteria criteria=new TServiceMoneyPayCriteria();
        TServiceMoneyPayCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
        cubCriteria.andCompanyIdEqualTo(dto.getCompanyId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<TServiceMoneyPay> result=tServiceMoneyPayMapper.selectByExample(criteria);
        List<MoneyPayVO> voList=new ArrayList<>();
        for(TServiceMoneyPay entity:result){
            MoneyPayVO vo=new MoneyPayVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
        }
        return Result.success(voList);
    }

    /**
     * 根据中标服务费表ID查询某标段供应商的服务费是否支付
     * @param dto
     * @return
     */
    @Override
    public Result<Boolean> IsPayForServiceMoney(QueryMoneyPayRecordDTO dto){
        TServiceMoneyPayRecordCriteria criteria=new TServiceMoneyPayRecordCriteria();
        TServiceMoneyPayRecordCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andMoneyPayIdEqualTo(dto.getMoneyPayId());
        cubCriteria.andOperaterIdEqualTo(dto.getOperaterId());
        cubCriteria.andOperaterNameEqualTo(dto.getOperaterName());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<TServiceMoneyPayRecord> result =tServiceMoneyPayRecordMapper.selectByExample(criteria);
        //compareTo 返回值 -1 小于 0 等于 1 大于
        if(result.size()>0 && result.get(0).getGuaranteePaymentReal().compareTo(dto.getServiceMoney())>-1){
            return Result.success(true);
        }else{
            return Result.success(false);
        }
    }

}
