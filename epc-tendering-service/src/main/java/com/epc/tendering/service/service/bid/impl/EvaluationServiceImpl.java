package com.epc.tendering.service.service.bid.impl;
import java.util.Date;

import com.epc.common.Result;
import com.epc.common.constants.AnnouncementProcessStatusEnum;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.domain.pretrial.TPretrialFile;
import com.epc.tendering.service.domain.pretrial.TPretrialFileCriteria;
import com.epc.tendering.service.domain.pretrial.TPretrialMessage;
import com.epc.tendering.service.domain.pretrial.TPretrialMessageCriteria;
import com.epc.tendering.service.mapper.bid.*;
import com.epc.tendering.service.mapper.pretrial.TPretrialFileMapper;
import com.epc.tendering.service.mapper.pretrial.TPretrialMessageMapper;
import com.epc.tendering.service.service.bid.EvaluationService;
import com.epc.web.facade.bidding.handle.CodeHandle;
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.handle.TechnologyHandle;
import com.epc.web.facade.bidding.vo.GuaranteeVO;
import com.epc.web.facade.bidding.vo.TPretrialFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

/**
 * <p>Description : easilys
 * <p>Date : 2018-09-25 13:55
 * <p>@Author : luozhixin
 * <p>EvaluationServiceImpl
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private BEvaluationTenderStandardMapper bEvaluationTenderStandardMapper;
    @Autowired
    private BTechnologyTenderStandardMapper bTechnologyTenderStandardMapper;
    @Autowired
    private BTenderAbolishClauseMapper bTenderAbolishClauseMapper;
    @Autowired
    private BBidsGuaranteeAmountMapper bBidsGuaranteeAmountMapper;
    @Autowired
    private BBidOpeningPayMapper bBidOpeningPayMapper;
    @Autowired
    private TPretrialMessageMapper tPretrialMessageMapper;
    @Autowired
    private TPretrialFileMapper tPretrialFileMapper;

    /**
     * 新增评标标准设定 评标标准因素
     * @param evaluationHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insertEvaluation(EvaluationHandle evaluationHandle) {
        //评标标准设定
        List<String> method = evaluationHandle.getPriceBidEvaluationMethod().getMethod();
        //评标标准因素
        List<TechnologyHandle> technologyHandleList = evaluationHandle.getTechnologyHandleList();
        this.insert(method,technologyHandleList,evaluationHandle);
        if(evaluationHandle.getTenderAbolishClause()!=null){
            //新增废除条款
            BTenderAbolishClause bTenderAbolishClause = new BTenderAbolishClause();
            bTenderAbolishClause.setOperateId(evaluationHandle.getOperateId());
            bTenderAbolishClause.setCreateAt(new Date());
            bTenderAbolishClause.setUpdateAt(new Date());
            bTenderAbolishClause.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            bTenderAbolishClause.setTenderAbolishClause(evaluationHandle.getTenderAbolishClause());
            bTenderAbolishClauseMapper.insertSelective(bTenderAbolishClause);
        }
        return Result.success();
    }

    /**
     * 查询开标的标段保证金
     * @param procurementProjectId 采购项目ID
     * @return
     */
    @Override
    public Result<List<GuaranteeVO>> selectGuarantee(Long procurementProjectId) {
        BBidsGuaranteeAmountCriteria criteria= new BBidsGuaranteeAmountCriteria();
        BBidsGuaranteeAmountCriteria.Criteria subCriterid = criteria.createCriteria();
        subCriterid.andProcurementProjectIdEqualTo(procurementProjectId);
        //查询
        List<BBidsGuaranteeAmount> bBidsGuaranteeAmounts = bBidsGuaranteeAmountMapper.selectByExample(criteria);
        List<BBidOpeningPay> bBidOpeningPays = null;
        for (int i = 0; i < bBidsGuaranteeAmounts.size(); i++) {
            BBidOpeningPayCriteria bBidOpeningPayCriteria = new BBidOpeningPayCriteria();
            BBidOpeningPayCriteria.Criteria subBBidOpeningPayCriteria = bBidOpeningPayCriteria.createCriteria();
            subBBidOpeningPayCriteria.andBidsGuaranteeAmountIdEqualTo(bBidsGuaranteeAmounts.get(i).getId());
            bBidOpeningPays = bBidOpeningPayMapper.selectByExample(bBidOpeningPayCriteria);
        }
        //写入VO返回
        List<GuaranteeVO> guaranteeVOS = new LinkedList<>();
        for (int i = 0; i < bBidsGuaranteeAmounts.size(); i++) {
            GuaranteeVO guaranteeVO = new GuaranteeVO();
            guaranteeVO.setProcurementProjectId(bBidsGuaranteeAmounts.get(i).getProcurementProjectId());
            guaranteeVO.setBIssueDocumentsId(bBidsGuaranteeAmounts.get(i).getbIssueDocumentsId());
            guaranteeVO.setBidsId(bBidsGuaranteeAmounts.get(i).getBidsId());
            guaranteeVO.setBidsGuaranteeAmountId(bBidOpeningPays.get(i).getBidsGuaranteeAmountId());
            guaranteeVO.setTendererId(bBidOpeningPays.get(i).getTendererId());
            guaranteeVO.setTendererCompanyId(bBidOpeningPays.get(i).getTendererCompanyId());
            guaranteeVO.setPaymentId(bBidOpeningPays.get(i).getPaymentId());
            guaranteeVO.setTenderGuaranteeAmount(bBidsGuaranteeAmounts.get(i).getTenderGuaranteeAmount());
            guaranteeVO.setBidsName(bBidsGuaranteeAmounts.get(i).getBidsName());
            guaranteeVO.setReceivables(bBidsGuaranteeAmounts.get(i).getReceivables());
            guaranteeVO.setBankAccount(bBidsGuaranteeAmounts.get(i).getBankAccount());
            guaranteeVO.setTendererName(bBidOpeningPays.get(i).getTendererName());
            guaranteeVO.setTendererCompanyName(bBidOpeningPays.get(i).getTendererName());
            guaranteeVO.setAmountMoneyTime(bBidOpeningPays.get(i).getAmountMoneyTime());
            guaranteeVO.setAmountMoney(bBidOpeningPays.get(i).getPaymentAccountNumber());
            guaranteeVO.setPaymentName(bBidOpeningPays.get(i).getPaymentName());
            guaranteeVO.setPaymentAccountNumber(bBidOpeningPays.get(i).getPaymentAccountNumber());
            guaranteeVOS.add(guaranteeVO);
        }
        return Result.success(guaranteeVOS);
    }

    /**
     * 查询对应投递文件列表
     * @param companyId 公司id
     * @return
     */
    @Override
    public Result<List<TPretrialFileVO>> getFilesByCompanyId(Long companyId) {
        //公司id 作为条件查询预审信息
        TPretrialMessageCriteria criteria = new TPretrialMessageCriteria();
        TPretrialMessageCriteria.Criteria subMessageCriteria = criteria.createCriteria();
        subMessageCriteria.andCompanyIdEqualTo(companyId);
        List<TPretrialMessage> tPretrialMessages = tPretrialMessageMapper.selectByExample(criteria);
        TPretrialFileCriteria fileCriteria = new TPretrialFileCriteria();
        TPretrialFileCriteria.Criteria subFileCriteria = fileCriteria.createCriteria();
        List<TPretrialFile> tPretrialFiles =new ArrayList<>();
        //通过预审信息查询对应文件
        for (int i = 0; i < tPretrialMessages.size(); i++) {
            subFileCriteria.andIdEqualTo(tPretrialMessages.get(i).getId());
            tPretrialFiles = tPretrialFileMapper.selectByExample(fileCriteria);
        }
       List<TPretrialFileVO> tPretrialFileVOS = new LinkedList<>();
        for (int i = 0; i < tPretrialFiles.size(); i++) {
            TPretrialFileVO tPretrialFileVO= new TPretrialFileVO();
            tPretrialFileVO.setPurchaseProjectId(tPretrialMessages.get(i).getPurchaseProjectId());
            tPretrialFileVO.setReleaseAnnouncementId(tPretrialMessages.get(i).getReleaseAnnouncementId());
            tPretrialFileVO.setCompanyId(tPretrialMessages.get(i).getCompanyId());
            tPretrialFileVO.setStatus(tPretrialMessages.get(i).getStatus());
            tPretrialFileVO.setContent(tPretrialMessages.get(i).getContent());
            tPretrialFileVO.setFilePath(tPretrialFiles.get(i).getFilePath());
            tPretrialFileVO.setFileName(tPretrialFiles.get(i).getFileName());
            tPretrialFileVOS.add(tPretrialFileVO);
        }
        return Result.success(tPretrialFileVOS);
    }

    /**
     * 新增办法因素
     * @param method
     * @param technologyHandleList
     * @param evaluationHandle
     */
    public  void insert(List<String> method,List<TechnologyHandle> technologyHandleList ,EvaluationHandle evaluationHandle){
        try {
            for (String meth : method) {
                BEvaluationTenderStandard bEvaluationTenderStandard = new BEvaluationTenderStandard();
                bEvaluationTenderStandard.setProcessStatus(AnnouncementProcessStatusEnum.RELEASED.getCode());
                bEvaluationTenderStandard.setProcurementProjectId(evaluationHandle.getProcurementProjectId());
                bEvaluationTenderStandard.setBidsId(evaluationHandle.getBidsId());
                bEvaluationTenderStandard.setOperateId(evaluationHandle.getOperateId());
                bEvaluationTenderStandard.setCreateAt(new Date());
                bEvaluationTenderStandard.setUpdateAt(new Date());
                bEvaluationTenderStandard.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                bEvaluationTenderStandard.setPriceBidEvaluationMethod(meth);
                this.bEvaluationTenderStandardMapper.insertSelective(bEvaluationTenderStandard);
                for (TechnologyHandle technologyHandle : technologyHandleList) {
                    BTechnologyTenderStandard bTechnologyTenderStandard = new BTechnologyTenderStandard();
                    bTechnologyTenderStandard.setEvaluationTenderStandardId(bEvaluationTenderStandard.getId());
                    bTechnologyTenderStandard.setEvaluationFactors(technologyHandle.getEvaluationFactors());
                    bTechnologyTenderStandard.setExplain(technologyHandle.getExplain());
                    bTechnologyTenderStandard.setDividingRangeStart(technologyHandle.getDividingRangeStart());
                    bTechnologyTenderStandard.setDividingRangeEnd(technologyHandle.getDividingRangeEnd());
                    bTechnologyTenderStandard.setOperateId(evaluationHandle.getOperateId());
                    bTechnologyTenderStandard.setCreateAt(new Date());
                    bTechnologyTenderStandard.setUpdateAt(new Date());
                    bTechnologyTenderStandard.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    this.bTechnologyTenderStandardMapper.insertSelective(bTechnologyTenderStandard);
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }
}
