package com.epc.tendering.service.service.question.impl;

import com.epc.common.Result;
import com.epc.tendering.service.domain.question.BAnswerQuestion;
import com.epc.tendering.service.domain.question.BAnswerQuestionCriteria;
import com.epc.tendering.service.domain.question.BAnswerQuestionWithBLOBs;
import com.epc.tendering.service.domain.supplier.TSupplierDetailInfo;
import com.epc.tendering.service.domain.supplier.TSupplierDetailInfoCriteria;
import com.epc.tendering.service.domain.winBid.TWinBid;
import com.epc.tendering.service.domain.winBid.TWinBidCriteria;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.question.BAnswerQuestionMapper;
import com.epc.tendering.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.tendering.service.mapper.winBid.TWinBidMapper;
import com.epc.tendering.service.service.question.BAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.QueryAnswerQuestionDTO;
import com.epc.web.facade.terdering.answer.query.QueryPublicityDTO;
import com.epc.web.facade.terdering.answer.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 14:50
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BAnswerQuestionServiceImpl implements BAnswerQuestionService {
    @Autowired
    private BAnswerQuestionMapper bAnswerQuestionMapper;
    @Autowired
    private TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    private TWinBidMapper tWinBidMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;


    @Override
    public Result<List<FacadeAnswerQuestionVO>> getQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        List<FacadeAnswerQuestionVO> returnList = new ArrayList<>();
        final BAnswerQuestionCriteria criteria = new BAnswerQuestionCriteria();
        final BAnswerQuestionCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andProcurementProjectIdEqualTo(queryAnswerQuestionDTO.getProcurementProjectId());
        if (StringUtils.isNotBlank(queryAnswerQuestionDTO.getQuestionerName())) {
            subCriteria.andQuestionerNameEqualTo(queryAnswerQuestionDTO.getQuestionerName());
        }
        if (StringUtils.isNotBlank(queryAnswerQuestionDTO.getStatus())) {
            subCriteria.andStatusEqualTo(queryAnswerQuestionDTO.getStatus());
        }
        criteria.setOrderByClause("id desc");
        List<BAnswerQuestionWithBLOBs> withBLOBsList = bAnswerQuestionMapper.selectByExampleWithBLOBsWithRowbounds(criteria, queryAnswerQuestionDTO.getRowBounds());
        for (BAnswerQuestionWithBLOBs item : withBLOBsList) {
            FacadeAnswerQuestionVO pojo = new FacadeAnswerQuestionVO();
            BeanUtils.copyProperties(item, pojo);
            returnList.add(pojo);
        }
        return Result.success(returnList);
    }

    @Override
    public Result<Boolean> replyQuestion(HandleReplyQuestion handleReplyQuestion) {
        BAnswerQuestionWithBLOBs questionWithBLOBs = bAnswerQuestionMapper.selectByPrimaryKey(handleReplyQuestion.getId());
        questionWithBLOBs.setAnswerId(handleReplyQuestion.getOperateId());
        questionWithBLOBs.setAnswerName(handleReplyQuestion.getOperateName());
        questionWithBLOBs.setUpdateAt(new Date());
        questionWithBLOBs.setStatus("replied");
        questionWithBLOBs.setAnswer(handleReplyQuestion.getAnswer());
        return Result.success(bAnswerQuestionMapper.updateByPrimaryKeyWithBLOBs(questionWithBLOBs) > 0);
    }

    @Override
    public Result<List<PublicityVO>> getPublicityListOfficialNetwork(QueryPublicityDTO QueryPublicityDTO) {
        List<PublicityVO> returnList = new ArrayList<>();
        //公告-announcement,招标文件-bidFile,评标-bidEvaluation
        BAnswerQuestionCriteria criteria = new BAnswerQuestionCriteria();
        criteria.createCriteria().andQuestionTypeEqualTo(QueryPublicityDTO.getType()).andStatusEqualTo("replied");
        List<BAnswerQuestionWithBLOBs> bAnswerQuestionList = bAnswerQuestionMapper.selectByExampleWithBLOBs(criteria);
        for (BAnswerQuestionWithBLOBs item : bAnswerQuestionList) {
            PublicityVO publicityVO= tPurchaseProjectBasicInfoMapper.getDetailInfoById(item.getProcurementProjectId());
            List<PublicitySubVO> list = bAnswerQuestionMapper.getListGroupByProcurementProjectId(item.getProcurementProjectId());
            publicityVO.setAnswerProblemList(list);
            returnList.add(publicityVO);
        }

        return Result.success(returnList);
    }

    /**
     * 查询中标公示
     * @return
     */
    @Override
    public Result<List<WinBidVO>> getBidPublicity() {
        TWinBidCriteria tWinBidCriteria = new TWinBidCriteria();
        tWinBidCriteria.setOrderByClause("id desc");
        List<TWinBid> tWinBids = tWinBidMapper.selectByExample(tWinBidCriteria);
        List<WinBidVO> winBidVOS = new ArrayList<>();
        for (TWinBid tWinBid : tWinBids) {
            TSupplierDetailInfoCriteria tSupplierDetailInfoCriteria = new TSupplierDetailInfoCriteria();
            tSupplierDetailInfoCriteria.createCriteria().andSupplierIdEqualTo(tWinBid.getSupplierId());
            List<TSupplierDetailInfo> tSupplierDetailInfos = tSupplierDetailInfoMapper.selectByExample(tSupplierDetailInfoCriteria);
            WinBidVO winBidVO = new WinBidVO();
            winBidVO.setBidName(tWinBid.getBidName());
            winBidVO.setCreateAt(tWinBid.getCreateAt());
            winBidVO.setSupplierName(tSupplierDetailInfos.get(0).getCompanyName());
            winBidVOS.add(winBidVO);
        }
        return Result.success(winBidVOS);
    }

    @Override
    public Result<List<MonitorAnswerQuestionVO>> getProcurementProjectAnswerQuestionList(QueryAnswerQuestionDTO queryAnswerQuestionDTO) {
        List<MonitorAnswerQuestionVO> returnList = new ArrayList<>();
        BAnswerQuestionCriteria criteria = new BAnswerQuestionCriteria();
        BAnswerQuestionCriteria.Criteria subCriteria = criteria.createCriteria();
        criteria.setOrderByClause("id desc");
        if(queryAnswerQuestionDTO.getProcurementProjectId() !=null){
            subCriteria.andProcurementProjectIdEqualTo(queryAnswerQuestionDTO.getProcurementProjectId());
        }
        List<BAnswerQuestion> questionList = bAnswerQuestionMapper.selectByExample(criteria);
        for (BAnswerQuestion item : questionList) {
            MonitorAnswerQuestionVO pojo = new MonitorAnswerQuestionVO();
            BeanUtils.copyProperties(item, pojo);
            returnList.add(pojo);
        }
        return Result.success(returnList);
    }
}
