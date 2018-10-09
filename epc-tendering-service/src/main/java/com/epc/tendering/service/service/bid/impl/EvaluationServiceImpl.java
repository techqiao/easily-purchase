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
import com.epc.web.facade.bidding.handle.EvaluationHandle;
import com.epc.web.facade.bidding.handle.StandardTypeHandle;
import com.epc.web.facade.bidding.vo.ClauseTemplateVO;
import com.epc.web.facade.bidding.vo.GuaranteeVO;
import com.epc.web.facade.bidding.vo.TPretrialFileVO;
import org.springframework.beans.BeanUtils;
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
    private BTenderAbolishClauseTemplateMapper bTenderAbolishClauseTemplateMapper;
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
     * 新增评标标准设定  废标条款
     * @param evaluationHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertEvaluation(EvaluationHandle evaluationHandle) {
        List<StandardTypeHandle> standardType = evaluationHandle.getStandardType();
        List<Long> evaluationIds= new ArrayList<>();
        try {
            for (StandardTypeHandle standardTypeHandle : standardType) {
                BEvaluationTenderStandard bEvaluationTenderStandard = new BEvaluationTenderStandard();
                bEvaluationTenderStandard.setStandardType(standardTypeHandle.getStandardType());
                bEvaluationTenderStandard.setTypeScore(standardTypeHandle.getTechTypeScore());
                bEvaluationTenderStandard.setMemo(standardTypeHandle.getMemo());
                bEvaluationTenderStandard.setFilePath(standardTypeHandle.getFilePath());
                bEvaluationTenderStandard.setProcurementProjectId(evaluationHandle.getProcurementProjectId());
                bEvaluationTenderStandard.setBidsId(evaluationHandle.getBidsId());
                bEvaluationTenderStandard.setProcessStatus(AnnouncementProcessStatusEnum.RELEASED.getCode());
                bEvaluationTenderStandard.setOperateId(evaluationHandle.getOperateId());
                bEvaluationTenderStandard.setCreateAt(new Date());
                bEvaluationTenderStandard.setUpdateAt(new Date());
                bEvaluationTenderStandard.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
                    bEvaluationTenderStandardMapper.insertSelective(bEvaluationTenderStandard);
                    if(!evaluationHandle.getTenderAbolishClauseList().isEmpty()){
                        Long evaluationId = bEvaluationTenderStandard.getId();
                        evaluationIds.add(evaluationId);
                    }
            }
            return  Result.success(insertClause(evaluationHandle,evaluationIds)>0);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error();
        }
    }

    /**
     * 根据id查询对应废标模板
     * @param id 废标模板id
     * @return
     */
    @Override
    public Result<ClauseTemplateVO> getClauseTemplateById(Long id) {
        ClauseTemplateVO clauseTemplateVO = new ClauseTemplateVO();
        BTenderAbolishClauseTemplate bTenderAbolishClauseTemplate = bTenderAbolishClauseTemplateMapper.selectByPrimaryKey(id);
        if(null==bTenderAbolishClauseTemplate){
            return Result.success(clauseTemplateVO);
        }
        clauseTemplateVO.setFilePath(bTenderAbolishClauseTemplate.getFilePath());
        clauseTemplateVO.setClauseName(bTenderAbolishClauseTemplate.getClauseName());
       return Result.success(clauseTemplateVO);
    }

    /**
     * 查询开标的标段保证金
     * @param procurementProjectId 采购项目ID
     * @return
     */
    @Override
    public Result<List<GuaranteeVO>> selectGuarantee(Long procurementProjectId) {
        //写入VO返回
        List<GuaranteeVO> guaranteeVOS = new LinkedList<>();
        BBidsGuaranteeAmountCriteria criteria= new BBidsGuaranteeAmountCriteria();
        BBidsGuaranteeAmountCriteria.Criteria subCriterid = criteria.createCriteria();
        subCriterid.andProcurementProjectIdEqualTo(procurementProjectId);
        //查询
        List<BBidsGuaranteeAmount> bBidsGuaranteeAmounts = bBidsGuaranteeAmountMapper.selectByExample(criteria);
        List<BBidOpeningPay> bBidOpeningPays = new ArrayList<>();
        for (int i = 0; i < bBidsGuaranteeAmounts.size(); i++) {
            BBidOpeningPayCriteria bBidOpeningPayCriteria = new BBidOpeningPayCriteria();
            BBidOpeningPayCriteria.Criteria subBBidOpeningPayCriteria = bBidOpeningPayCriteria.createCriteria();
            subBBidOpeningPayCriteria.andBidsGuaranteeAmountIdEqualTo(bBidsGuaranteeAmounts.get(i).getId());
            bBidOpeningPays = bBidOpeningPayMapper.selectByExample(bBidOpeningPayCriteria);
        }
        if(bBidOpeningPays.isEmpty()){
            return Result.success(guaranteeVOS);
        }
        for (int i = 0; i < bBidsGuaranteeAmounts.size(); i++) {
            GuaranteeVO guaranteeVO = new GuaranteeVO();
            BeanUtils.copyProperties(bBidsGuaranteeAmounts.get(i),guaranteeVO);
            BeanUtils.copyProperties(bBidOpeningPays.get(i),guaranteeVO);
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

    public int insertClause(EvaluationHandle evaluationHandle ,List<Long> evaluationIds){
        for (int i = 0; i < evaluationHandle.getTenderAbolishClauseList().size(); i++) {
            BTenderAbolishClause bTenderAbolishClause = new BTenderAbolishClause();
            bTenderAbolishClause.setEvaluationTenderStandardId(evaluationIds.get(i));
            bTenderAbolishClause.setTemplateId(evaluationHandle.getTenderAbolishClauseList().get(i).getTemplateId());
            bTenderAbolishClause.setOperateId(evaluationHandle.getOperateId());
            bTenderAbolishClause.setCreateAt(new Date());
            bTenderAbolishClause.setUpdateAt(new Date());
            bTenderAbolishClause.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            return bTenderAbolishClauseMapper.insertSelective(bTenderAbolishClause);
        }
        return 0;
    }

}
