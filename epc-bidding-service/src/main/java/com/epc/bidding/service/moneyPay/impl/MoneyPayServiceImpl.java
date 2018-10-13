package com.epc.bidding.service.moneyPay.impl;

import com.epc.bidding.domain.*;
import com.epc.bidding.mapper.*;
import com.epc.bidding.service.moneyPay.MoneyPayService;
import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.DateTimeUtil;
import com.epc.web.facade.bidding.dto.IsPayDTO;
import com.epc.web.facade.bidding.handle.HandleFilePay;
import com.epc.web.facade.bidding.handle.HandleGuaranteeAmountPay;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayDTO;
import com.epc.web.facade.bidding.query.moneyPay.QueryMoneyPayRecordDTO;
import com.epc.web.facade.bidding.query.moneyPay.ServiceMoneyListForAllDTO;
import com.epc.web.facade.bidding.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
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
    @Autowired
    TPurchaseProjectBidsMapper tPurchaseProjectBidsMapper;
    @Autowired
    TWinBidMapper tWinBidMapper;
    @Autowired
    TPurchaseProjectFileDownloadMapper tPurchaseProjectFileDownloadMapper;
    @Autowired
    PlatformBankAccountMapper platformBankAccountMapper;
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

       TPurchaseProjectBidsCriteria craters=new TPurchaseProjectBidsCriteria();
       TPurchaseProjectBidsCriteria.Criteria cubCrater=craters.createCriteria();
       cubCrater.andPurchaseProjectIdEqualTo(dto.getPurchaseProjectId());
       cubCrater.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
       //查询采购项目Id 下的标段列表
       List<TPurchaseProjectBids> bidsList=tPurchaseProjectBidsMapper.selectByExample(craters);
       List<MoneyPayVO> voList=new ArrayList<>();

       for(TPurchaseProjectBids bids:bidsList){
           MoneyPayVO vo=new MoneyPayVO();
           vo.setBidId(bids.getId());
           vo.setBidName(bids.getBidName());
           vo.setBidMoney(bids.getGuaranteePayment());
           vo.setStatus("未支付");
           //查询 标段下保证金支付记录
           BBidOpeningPayCriteria criteria=new BBidOpeningPayCriteria();
           BBidOpeningPayCriteria.Criteria cubCriteria=criteria.createCriteria();
           cubCriteria.andTendererCompanyIdEqualTo(dto.getCompanyId());
           cubCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
           cubCriteria.andBidIdEqualTo(bids.getId());
           List<BBidOpeningPay> result=bBidOpeningPayMapper.selectByExample(criteria);
           for(BBidOpeningPay entity:result){
               //判断是否支付成功
               if(entity.getAmountMoney()!=null && entity.getAmountMoney().compareTo(vo.getBidMoney())>-1){
                   vo.setStatus("已支付");
               }
           }
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
         * 查询采购项目下 标段供应商的服务费是否支付
         * @param dto
         * @return
         */
    @Override
    public Result<List<ServicePayVO>> IsPayForServiceMoney(QueryMoneyPayRecordDTO dto){
        TWinBidCriteria bidCriteria=new TWinBidCriteria();
        TWinBidCriteria.Criteria cubBidCriteria=bidCriteria.createCriteria();
        cubBidCriteria.andProcurementProjectIdEqualTo(dto.getPurchaseProjectId());
        cubBidCriteria.andSupplierIdEqualTo(dto.getCompanyId());
        cubBidCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //查看 采购项目中,供应商中标记录列表
        List<TWinBid> winBidList=tWinBidMapper.selectByExample(bidCriteria);
        List<ServicePayVO> voList=new ArrayList<>();
        for(TWinBid entity:winBidList){
            TServiceMoneyPayCriteria payCriteria=new TServiceMoneyPayCriteria();
            TServiceMoneyPayCriteria.Criteria cubPayCriteria=payCriteria.createCriteria();
            cubPayCriteria.andBidIdEqualTo(entity.getBidId());
            //获取 标段中标服务费详情
            List<TServiceMoneyPay> moneyPayList=tServiceMoneyPayMapper.selectByExample(payCriteria);
            for(TServiceMoneyPay result:moneyPayList){
                ServicePayVO vo=new ServicePayVO();
                BeanUtils.copyProperties(result,vo);
                if(result.getStatus().equals(0)){
                    vo.setStatus("未支付");
                }else  if(result.getStatus().equals(1)){
                    vo.setStatus("已支付");
                }
                voList.add(vo);
            }
        }
        return Result.success(voList);
    }


    /**
     * 缴费列表（all） 标段供应商的服务费是否支付
     * @param dto
     * @return
     */
    @Override
    public Result<List<PayListForAllVO>> getServiceMoneyListForAll(ServiceMoneyListForAllDTO dto){
        TWinBidCriteria bidCriteria=new TWinBidCriteria();
        TWinBidCriteria.Criteria cubBidCriteria=bidCriteria.createCriteria();
        cubBidCriteria.andSupplierIdEqualTo(dto.getCompanyId());
        cubBidCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //查看 采购项目中,供应商中标记录列表
        List<TWinBid> winBidList=tWinBidMapper.selectByExample(bidCriteria);
        List<PayListForAllVO> voList=new ArrayList<>();
        for(TWinBid entity:winBidList){
            PayListForAllVO vo=new PayListForAllVO();
            TServiceMoneyPayCriteria payCriteria=new TServiceMoneyPayCriteria();
            TServiceMoneyPayCriteria.Criteria cubPayCriteria=payCriteria.createCriteria();
            cubPayCriteria.andBidIdEqualTo(entity.getBidId());
            //获取 标段中标服务费详情
            List<TServiceMoneyPay> moneyPayList=tServiceMoneyPayMapper.selectByExample(payCriteria);
            for(TServiceMoneyPay result:moneyPayList){
                //获取项目详情
                if(result.getBidId()!=null){
                    TPurchaseProjectBids purchaseProjectBids=tPurchaseProjectBidsMapper.selectByPrimaryKey(result.getBidId());
                    vo.setBidId(result.getBidId());
                    vo.setBidName(result.getBidName());
                    vo.setProjectCode(purchaseProjectBids.getProjectCode());
                    vo.setProjectName(purchaseProjectBids.getProjectName());
                }
                //获取采购项目详情
                TPurchaseProjectBasicInfo purchaseProjectBasicInfo=tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(result.getProcurementProjectId());
                if(purchaseProjectBasicInfo!=null){
                    vo.setStartDate(DateTimeUtil.dateToStr(purchaseProjectBasicInfo.getPurchaseStartTime()));
                    vo.setEndDate(DateTimeUtil.dateToStr(purchaseProjectBasicInfo.getPurchaseEndTime()));
                    vo.setProjectStatus(purchaseProjectBasicInfo.getIsEnd());
                }

                if(result.getStatus().equals(0)){
                    vo.setPayStatus("未支付");
                }else  if(result.getStatus().equals(1)){
                    vo.setPayStatus("已支付");
                }else  if(result.getStatus().equals(2)){
                    vo.setPayStatus("已退回");
                }
                voList.add(vo);
            }
        }

        //条件查询
        List<PayListForAllVO> firstList=new ArrayList<>();
        List<PayListForAllVO> secondList=new ArrayList<>();
        List<PayListForAllVO> ThreeList=new ArrayList<>();
        if(dto.getProjectName()!=null){
            for(PayListForAllVO newVo :voList){
                if(newVo.getProjectName().contains(dto.getProjectName())){
                    firstList.add(newVo);
                }
            }
        }else{
            firstList=voList;
        }
        if(dto.getProjectStatus()!=null){
            for(PayListForAllVO newVo :firstList){
                if(newVo.getProjectStatus().equals(dto.getProjectStatus())){
                    secondList.add(newVo);
                }
            }
        }else{
            secondList=firstList;
        }
        if(dto.getPayStatus()!=null){
            for(PayListForAllVO newVo :secondList){
                if(newVo.getPayStatus().equals(dto.getPayStatus())){
                    ThreeList.add(newVo);
                }
            }
        }else {
            ThreeList=secondList;
        }
        return Result.success(ThreeList);
    }
    /**
     * 保证金退还列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<ServiceBackVO>> getGuarantyBackPayList(QueryMoneyPayRecordDTO dto){
        //根据采购项目id 和 公司id 查询保证金支付列表
        BBidOpeningPayCriteria criteria =new BBidOpeningPayCriteria();
        BBidOpeningPayCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andProcurementProjectIdEqualTo(dto.getPurchaseProjectId());
        cubCriteria.andTendererCompanyIdEqualTo(dto.getCompanyId());
        criteria.setOrderByClause("create_at desc");
        List<ServiceBackVO> voList=new ArrayList<>();

        List<BBidOpeningPay> result=bBidOpeningPayMapper.selectByExample(criteria);
        for(BBidOpeningPay entity:result){
            ServiceBackVO vo= new ServiceBackVO();
            //获取项目详情
            TProjectBasicInfo projectBasicInfo=tProjectBasicInfoMapper.selectByPrimaryKey(entity.getProjectId());
            vo.setProjectCode(projectBasicInfo.getProjectCode());
            vo.setProjectName(projectBasicInfo.getProjectName());
            //获取标段
            TPurchaseProjectBids  purchaseProjectBids=tPurchaseProjectBidsMapper.selectByPrimaryKey(entity.getBidId());
            vo.setBidCode(purchaseProjectBids.getBidCode());
            vo.setBidName(purchaseProjectBids.getBidName());
            //标段保证金详情
            BBidsGuaranteeAmount bidsGuaranteeAmount=bBidsGuaranteeAmountMapper.selectByPrimaryKey(entity.getBidsGuaranteeAmountId());
            vo.setBidMoney(bidsGuaranteeAmount.getTenderGuaranteeAmount());
            //支付详情信息
            if(entity.getIsBack().equals(0)){
                vo.setStatus("未退还");
            }else  if(entity.getIsBack().equals(1)){
                vo.setStatus("已退还");
            }
            voList.add(vo);
        }
        return Result.success(voList);
    }


    /**
     * 查询供应商是否支付下载招标文件金额
     * @return
     */
    @Override
    public IsPayDTO IsPayForProjectFile(QueryProgramPayDTO dto){
        IsPayDTO isPayDTO=new IsPayDTO();
        if(dto.getProcurementProjectId()==null){
            isPayDTO.setIsPay(false);
            return  isPayDTO;
        }
        final TPurchaseProjectFileDownloadCriteria criteria=new TPurchaseProjectFileDownloadCriteria();
        final TPurchaseProjectFileDownloadCriteria.Criteria subCriteria=criteria.createCriteria();
        subCriteria.andPurchaseProjectIdEqualTo(dto.getProcurementProjectId());
        subCriteria.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        //根据采购项目Id 查询招标文件
        List<TPurchaseProjectFileDownload> list=tPurchaseProjectFileDownloadMapper.selectByExample(criteria);
        if(list.size()==0){
            LOGGER.error("尚未发布招标文件");
            isPayDTO.setIsPay(false);
            return  isPayDTO;
        }
        //获取招标文件ID
        Long fileId=list.get(0).getId();
        BigDecimal money=list.get(0).getFilePayment();
        isPayDTO.setMoney(money);
        //根据招标文件ID 和 下载机构id 查询是否付费 t_purchase_project_file_pay
        final TPurchaseProjectFilePayCriteria pay =new TPurchaseProjectFilePayCriteria();
        final TPurchaseProjectFilePayCriteria.Criteria subPay=pay.createCriteria();
        subPay.andCompanyIdEqualTo(dto.getCompanyId());
        subPay.andPurchaseProjectFileIdEqualTo(fileId);
        subPay.andIsDeletedEqualTo(Const.IS_DELETED.NOT_DELETED);
        List<TPurchaseProjectFilePay> payList=tPurchaseProjectFilePayMapper.selectByExample(pay);
        //未查询到支付记录
        if(payList.size()==0){
            LOGGER.error("未找到支付记录");
            isPayDTO.setIsPay(false);
            return  isPayDTO;
        }else{
            //(实付金额 比对 下载金额)
            for(TPurchaseProjectFilePay entity:payList){
                if(entity.getFilePaymentReal().compareTo(money)>-1){
                    isPayDTO.setIsPay(true);
                    //获取招标文件路径
                    BSaleDocumentsCriteria criteria1=new BSaleDocumentsCriteria();
                    BSaleDocumentsCriteria.Criteria cubCriteria=criteria1.createCriteria();
                    cubCriteria.andProcurementProjectIdEqualTo(dto.getProcurementProjectId());
                   List<BSaleDocuments>  entityList=bSaleDocumentsMapper.selectByExample(criteria1);
                   if(!CollectionUtils.isEmpty(entityList)){
                       isPayDTO.setFilePath(entityList.get(0).getBiddingDocumentsUpUrl());
                   }
                }
            }
            return  isPayDTO;
        }
    }

    /**
     * 根据支付类型 获取 对应银行信息
     * @param documents
     * @return
     */
    @Override
    public BankAccountVO getBankAccount(int documents){

        PlatformBankAccountCriteria criteria=new PlatformBankAccountCriteria();
        PlatformBankAccountCriteria.Criteria cubCriteria=criteria.createCriteria();

        if(documents==Const.PAYMENT_TYPE.DOCUMENTS){
            cubCriteria.andPaymentTypeEqualTo(Const.PAYMENT_TYPE.DOCUMENTS);
        }else if(documents==Const.PAYMENT_TYPE.GUARANTY){
            cubCriteria.andPaymentTypeEqualTo(Const.PAYMENT_TYPE.GUARANTY);
        }else if(documents==Const.PAYMENT_TYPE.SERVICE){
            cubCriteria.andPaymentTypeEqualTo(Const.PAYMENT_TYPE.SERVICE);
        }

        List<PlatformBankAccount> result = platformBankAccountMapper.selectByExample(criteria);
        BankAccountVO vo= new BankAccountVO();

        if(result.size()>0){
            PlatformBankAccount entity=result.get(0);
            BeanUtils.copyProperties(entity,vo);
        }
        return  vo;
    }
}
