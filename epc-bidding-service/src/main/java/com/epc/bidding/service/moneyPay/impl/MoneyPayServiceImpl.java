package com.epc.bidding.service.moneyPay.impl;

import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.moneyPay.MoneyPayService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.vo.MoneyPayVO;
import com.epc.web.facade.bidding.vo.newGuaranteeVO;
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

@Service
public class MoneyPayServiceImpl implements MoneyPayService {
    @Autowired
    TServiceMoneyPayMapper tServiceMoneyPayMapper;
    @Autowired
    TServiceMoneyPayRecordMapper tServiceMoneyPayRecordMapper;
    @Autowired
    TPurchaseProjectFilePayMapper tPurchaseProjectFilePayMapper;
    @Autowired
    BBidsGuaranteeAmountMapper bBidsGuaranteeAmountMapper;
    @Autowired
    BBidOpeningPayMapper bBidOpeningPayMapper;
    @Autowired
    TTenderMessageMapper tTenderMessageMapper;
    @Autowired
    TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    TProjectBasicInfoMapper tProjectBasicInfoMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(MoneyPayServiceImpl.class);

    /**
     * 获取 缴纳投标保证金列表(角色列表)
     * @param dto
     * @return
     */
    public Result<List<newGuaranteeVO>> getOutMoneyPayList(QueryMoneyPayDTO dto){
        TTenderMessageCriteria criteria=new TTenderMessageCriteria();
        TTenderMessageCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andCompanyIdEqualTo(dto.getCompanyId());
        cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<newGuaranteeVO> voList=new ArrayList<>();
        //参与的项目列表
        List<TTenderMessage> result=tTenderMessageMapper.selectByExample(criteria);
        for(TTenderMessage entity:result){
            newGuaranteeVO vo= new newGuaranteeVO();
            //查询缴费记录
            Long bidId=entity.getBidsId();
            BBidOpeningPayCriteria criterial=new BBidOpeningPayCriteria();
            BBidOpeningPayCriteria.Criteria newCriterial=criterial.createCriteria();
            newCriterial.andBidIdEqualTo(bidId);
            List<BBidOpeningPay> payEntity=bBidOpeningPayMapper.selectByExample(criterial);
            if(payEntity.size()==0){
                vo.setStatus("未缴纳");
            }else{
                vo.setStatus("已缴纳");
            }
            Long purchaseProjectId=entity.getPurchaseProjectId();
            TPurchaseProjectBasicInfo baseEntity= tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(purchaseProjectId);
            vo.setStartDate(baseEntity.getPurchaseStartTime());
            vo.setEndDate(baseEntity.getPurchaseEndTime());
            TProjectBasicInfo projectBasicInfo =tProjectBasicInfoMapper.selectByPrimaryKey(baseEntity.getProjectId());
            vo.setProjectName(projectBasicInfo.getProjectName());
            vo.setProjectCode(projectBasicInfo.getProjectCode());
            BSaleDocumentsCriteria criteria1b=new BSaleDocumentsCriteria();
            BSaleDocumentsCriteria.Criteria newcriteria1b=criteria1b.createCriteria();
            newcriteria1b.andProcurementProjectIdEqualTo(purchaseProjectId);
            List<BSaleDocuments> bSale=bSaleDocumentsMapper.selectByExample(criteria1b);
            if(bSale.size()>0){
                //截止时间
                vo.setDeadlineDate(bSale.get(0).getBiddingEndTime());
            }
        }
        return Result.success(voList);

    }

    /**
     * 获取 缴纳投标保证金列表
     * @param dto
     * @return
     */
   @Override
    public Result<List<MoneyPayVO>> getMoneyPayList(QueryMoneyPayDTO dto){
        TServiceMoneyPayCriteria criteria=new TServiceMoneyPayCriteria();
        TServiceMoneyPayCriteria.Criteria cubCriteria=criteria.createCriteria();
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
     * 平台插入（供应商下载文件支付记录）
     * @param handle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public  Result<Boolean> insertPurchaseProjectFilePay(HandleFilePay handle){
        TPurchaseProjectFilePay entity=new TPurchaseProjectFilePay();
        BeanUtils.copyProperties(handle,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try{
            tPurchaseProjectFilePayMapper.insertSelective(entity);
        }catch (Exception e){
            LOGGER.error("insertPurchaseProjectFilePay"+entity.toString()+"_"+e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  Result.error("插入失败");
        }
        return Result.success(true);
    }

    /**
     * 平台插入（标段保证金支付记录）
     * @param handle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public  Result<Boolean> insertGuaranteeAmountPay(HandleGuaranteeAmountPay handle){
        BBidsGuaranteeAmount entity=new BBidsGuaranteeAmount();
        BeanUtils.copyProperties(handle,entity);
        entity.setCreateAt(new Date());
        entity.setUpdateAt(new Date());
        entity.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        try{
            bBidsGuaranteeAmountMapper.insertSelective(entity);
        }catch (Exception e){
            LOGGER.error("insertGuaranteeAmountPay_"+entity.toString()+"_"+e.getMessage(),e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result.error("插入失败");
        }
        return Result.success(true);




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
            return Result.error();
        }
    }

}
