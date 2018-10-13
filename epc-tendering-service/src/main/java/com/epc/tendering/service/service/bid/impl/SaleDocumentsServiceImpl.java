package com.epc.tendering.service.service.bid.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.bid.*;
import com.epc.tendering.service.mapper.bid.BBidsGuaranteeAmountMapper;
import com.epc.tendering.service.mapper.bid.BSaleDocumentsFileMapper;
import com.epc.tendering.service.mapper.bid.BSaleDocumentsMapper;
import com.epc.tendering.service.mapper.bid.BTenderDocumentsPlaceSaleMapper;
import com.epc.tendering.service.service.bid.SaleDocumentsService;
import com.epc.web.facade.terdering.bid.handle.HandleBidsGuaranteeAmount;
import com.epc.web.facade.terdering.bid.handle.HandleDocuments;
import com.epc.web.facade.terdering.bid.handle.HandleUnderLine;
import com.epc.web.facade.terdering.bid.vo.BidsGuaranteeAmountVO;
import com.epc.web.facade.terdering.bid.vo.DocumentsVO;
import com.epc.web.facade.terdering.bid.vo.SaleDocumentsVO;
import com.epc.web.facade.terdering.bid.vo.UnderLineVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-25 13:16
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SaleDocumentsServiceImpl implements SaleDocumentsService {
    @Autowired
    private BSaleDocumentsMapper bSaleDocumentsMapper;
    @Autowired
    private BBidsGuaranteeAmountMapper bBidsGuaranteeAmountMapper;
    @Autowired
    private BTenderDocumentsPlaceSaleMapper bTenderDocumentsPlaceSaleMapper;
    @Autowired
    private BSaleDocumentsFileMapper bSaleDocumentsFileMapper;


    @Override
    public Result<Boolean> handleSaleDocuments(HandleDocuments handDocuments) {
        BSaleDocuments bSaleDocuments = new BSaleDocuments();
        //招标文件
        BeanUtils.copyProperties(handDocuments.getHandleSaleDocuments(), bSaleDocuments);
        HandleUnderLine handleUnderLine = handDocuments.getHandleUnderLine();
        BTenderDocumentsPlaceSale bTenderDocumentsPlaceSale = new BTenderDocumentsPlaceSale();
        //线下招标文件
        BeanUtils.copyProperties(handleUnderLine, bTenderDocumentsPlaceSale);

        bSaleDocuments.setCreateAt(new Date());
        bSaleDocuments.setUpdateAt(new Date());
        bSaleDocuments.setIsDeleted(Const.IS_DELETED.NOT_DELETED);

        bTenderDocumentsPlaceSale.setCreateAt(new Date());
        bTenderDocumentsPlaceSale.setUpdateAt(new Date());
        bTenderDocumentsPlaceSale.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        //新增招标文件
        if (bSaleDocuments.getId() == null && bTenderDocumentsPlaceSale.getId() == null
                && !handDocuments.getHandleBidsGuaranteeAmount().isEmpty()) {
            try {
                bSaleDocumentsMapper.insertSelective(bSaleDocuments);
                BSaleDocumentsFile bSaleDocumentsFile = new BSaleDocumentsFile();
                BeanUtils.copyProperties(handDocuments.getHandleSaleDocuments(), bSaleDocumentsFile);
                bSaleDocumentsFile.setSaleDocumentsId(bSaleDocuments.getId());
                bSaleDocumentsFileMapper.insertSelective(bSaleDocumentsFile);
                if (!bSaleDocuments.getIsUnderLine().equals(Const.IS_UNDER_LINE.UP)) {
                    bTenderDocumentsPlaceSale.setbIssueDocumentsId(bSaleDocuments.getId());
                    bTenderDocumentsPlaceSaleMapper.insertSelective(bTenderDocumentsPlaceSale);
                }
                List<HandleBidsGuaranteeAmount> list = handDocuments.getHandleBidsGuaranteeAmount();
                for (HandleBidsGuaranteeAmount item : list) {
                    item.setBIssueDocumentsId(bSaleDocuments.getId());
                    BBidsGuaranteeAmount pojo = new BBidsGuaranteeAmount();
                    BeanUtils.copyProperties(item,pojo);
                    pojo.setCreateAt(new Date());
                    pojo.setUpdateAt(new Date());
                    bBidsGuaranteeAmountMapper.insertSelective(pojo);
                }
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        //处理招标文件
        else if (bSaleDocuments.getId() != null && bTenderDocumentsPlaceSale.getId() != null
                && !handDocuments.getHandleBidsGuaranteeAmount().isEmpty()) {
            try {
                bSaleDocumentsMapper.updateByPrimaryKeySelective(bSaleDocuments);
                if (!bSaleDocuments.getIsUnderLine().equals(Const.IS_UNDER_LINE.UP)) {
                    bTenderDocumentsPlaceSaleMapper.updateByPrimaryKeySelective(bTenderDocumentsPlaceSale);
                }
                BSaleDocumentsFileCriteria criteria = new BSaleDocumentsFileCriteria();
                criteria.createCriteria().andProcurementProjectIdEqualTo(handDocuments.getHandleSaleDocuments().getProcurementProjectId());
                bSaleDocumentsFileMapper.deleteByExample(criteria);
                BSaleDocumentsFile bSaleDocumentsFile = new BSaleDocumentsFile();
                BeanUtils.copyProperties(handDocuments.getHandleSaleDocuments(), bSaleDocumentsFile);
                bSaleDocumentsFile.setSaleDocumentsId(bSaleDocuments.getId());
                bSaleDocumentsFileMapper.insertSelective(bSaleDocumentsFile);
                List<HandleBidsGuaranteeAmount> list = handDocuments.getHandleBidsGuaranteeAmount();
                for (HandleBidsGuaranteeAmount item : list) {
                    BBidsGuaranteeAmount pojo = new BBidsGuaranteeAmount();
                    BeanUtils.copyProperties(item, pojo);
                    pojo.setUpdateAt(new Date());
                    bBidsGuaranteeAmountMapper.updateByPrimaryKeySelective(pojo);
                }
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return Result.success();
    }

    @Override
    public Result<DocumentsVO> getSaleDocuments(Long id) {
        DocumentsVO documentsVO = new DocumentsVO();
        BSaleDocuments bSaleDocuments = bSaleDocumentsMapper.selectByPrimaryKey(id);
        SaleDocumentsVO saleDocumentsVO = new SaleDocumentsVO();
        BeanUtils.copyProperties(bSaleDocuments, saleDocumentsVO);
        //招标文件
        documentsVO.setSaleDocumentsVO(saleDocumentsVO);
        BTenderDocumentsPlaceSaleCriteria criteria = new BTenderDocumentsPlaceSaleCriteria();
        criteria.createCriteria().andBIssueDocumentsIdEqualTo(bSaleDocuments.getId());
        List<BTenderDocumentsPlaceSale> list = bTenderDocumentsPlaceSaleMapper.selectByExample(criteria);
        if (!list.isEmpty()) {
            UnderLineVO underLineVO = new UnderLineVO();
            BeanUtils.copyProperties(list.get(0), underLineVO);
            //线下招标文件
            documentsVO.setUnderLineVO(underLineVO);
        }
        BBidsGuaranteeAmountCriteria amountCriteria = new BBidsGuaranteeAmountCriteria();
        amountCriteria.createCriteria().andBIssueDocumentsIdEqualTo(bSaleDocuments.getId());
        List<BBidsGuaranteeAmount> amountList = bBidsGuaranteeAmountMapper.selectByExample(amountCriteria);
        List<BidsGuaranteeAmountVO> bidsGuaranteeAmountVOList = new ArrayList<>();
        if (!amountList.isEmpty()) {
            amountList.forEach(item -> {
                BidsGuaranteeAmountVO vo = new BidsGuaranteeAmountVO();
                BeanUtils.copyProperties(item, vo);
                bidsGuaranteeAmountVOList.add(vo);
            });
            //保证金列表
            documentsVO.setBidsGuaranteeAmountVOList(bidsGuaranteeAmountVOList);
        }
        return Result.success(documentsVO);
    }
}
