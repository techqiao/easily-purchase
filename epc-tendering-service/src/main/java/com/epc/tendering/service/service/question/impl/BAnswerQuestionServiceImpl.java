package com.epc.tendering.service.service.question.impl;

import com.epc.common.Result;
import com.epc.common.constants.ProcessStatusEnum;
import com.epc.common.util.DateTimeUtil;
import com.epc.tendering.service.domain.bid.LetterOfTender;
import com.epc.tendering.service.domain.bid.LetterOfTenderCriteria;
import com.epc.tendering.service.domain.bid.TWinBidNominate;
import com.epc.tendering.service.domain.bid.TWinBidNominateCriteria;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.question.BAnswerQuestion;
import com.epc.tendering.service.domain.question.BAnswerQuestionCriteria;
import com.epc.tendering.service.domain.question.BAnswerQuestionWithBLOBs;
import com.epc.tendering.service.mapper.bid.LetterOfTenderMapper;
import com.epc.tendering.service.mapper.bid.TWinBidNominateMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.mapper.question.BAnswerQuestionMapper;
import com.epc.tendering.service.mapper.supplier.TSupplierDetailInfoMapper;
import com.epc.tendering.service.service.question.BAnswerQuestionService;
import com.epc.web.facade.terdering.answer.handle.HandleReplyQuestion;
import com.epc.web.facade.terdering.answer.query.*;
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
    private TWinBidNominateMapper tWinBidNominateMapper;
    @Autowired
    private TSupplierDetailInfoMapper tSupplierDetailInfoMapper;
    @Autowired
    private LetterOfTenderMapper letterOfTenderMapper;

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
        BAnswerQuestionWithBLOBs questionWithBLOBs = new BAnswerQuestionWithBLOBs();
        questionWithBLOBs = bAnswerQuestionMapper.selectByPrimaryKey(handleReplyQuestion.getId());
        if(questionWithBLOBs==null){
            return Result.error("回复问题不存在");
        }
        Long operateId = handleReplyQuestion.getOperateId();
        questionWithBLOBs.setAnswerId(operateId);
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
     * 查询官网中标公示列表
     * @return
     */
    @Override
    public List<WinBidNominateVO> getBidPublicity() {
        TWinBidNominateCriteria tWinBidCriteria = new TWinBidNominateCriteria();
        tWinBidCriteria.setOrderByClause("create_at desc");
        TWinBidNominateCriteria.Criteria cubCriterial =tWinBidCriteria.createCriteria();
        cubCriterial.andProcessStatusEqualTo(ProcessStatusEnum.RELEASED.getCode());
        //获取中标公示列表
        List<TWinBidNominate> tWinBids = tWinBidNominateMapper.selectByExample(tWinBidCriteria);

        List<WinBidNominateVO> voList = new ArrayList<>();
        for (TWinBidNominate entity : tWinBids) {
            WinBidNominateVO vo =new WinBidNominateVO();

            FirstBidCompanyDTO firstDTO =new FirstBidCompanyDTO();
            SecondBidCompanyDTO secondDTO =new SecondBidCompanyDTO();
            ThreeBidCompanyDTO threeDTO =new ThreeBidCompanyDTO();

            //获取标段信息
            BeanUtils.copyProperties(entity,vo);
            vo.setOpenStart(DateTimeUtil.dateToStr(entity.getOpenStart()));
            vo.setOpenEnd(DateTimeUtil.dateToStr(entity.getOpenEnd()));
            //获取采购项目信息
            TPurchaseProjectBasicInfo tPurchaseProjectBasicInfo= tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(entity.getPurchaseProjectId());
            if(tPurchaseProjectBasicInfo!=null){
                vo.setPurchaseProjectName(tPurchaseProjectBasicInfo.getPurchaseProjectName());
                vo.setPurchaseProjectCode(tPurchaseProjectBasicInfo.getPurchaseProjectCode());
            }

            LetterOfTenderCriteria criteria=new LetterOfTenderCriteria();
            LetterOfTenderCriteria.Criteria cubCriteria=criteria.createCriteria();
            cubCriteria.andBidsIdEqualTo(entity.getBidId());

            //获取第一中标人信息
            firstDTO.setCompanyName(entity.getFirstCompanyname());
            firstDTO.setMoney(entity.getFirstPrice());
            //获取第一投标函信息
            cubCriteria.andSupplierIdEqualTo(entity.getFirstSupplierid());
            List<LetterOfTender> firstLetterOfTender=letterOfTenderMapper.selectByExample(criteria);
            if(firstLetterOfTender.size()>0){
                LetterOfTender firstLetter=firstLetterOfTender.get(0);
                BeanUtils.copyProperties(firstLetter,firstDTO);
                vo.setFirstBidCompany(firstDTO);
            }


            //获取第二中标人信息
            secondDTO.setCompanyName(entity.getFirstCompanyname());
            secondDTO.setMoney(entity.getFirstPrice());
            //获取第二投标函信息
            cubCriteria.andSupplierIdEqualTo(entity.getTwoSupplierid());
            List<LetterOfTender> SecondLetterOfTender=letterOfTenderMapper.selectByExample(criteria);
            if(SecondLetterOfTender.size()>0){
                LetterOfTender SecondLetter=SecondLetterOfTender.get(0);
                BeanUtils.copyProperties(SecondLetter,secondDTO);
                vo.setSecondBidCompany(secondDTO);

            }

            //获取第三中标人信息
            threeDTO.setCompanyName(entity.getFirstCompanyname());
            threeDTO.setMoney(entity.getFirstPrice());
            //获取第三投标函信息
            cubCriteria.andSupplierIdEqualTo(entity.getThreeSupplierid());
            List<LetterOfTender> ThreeLetterOfTender=letterOfTenderMapper.selectByExample(criteria);
            if(ThreeLetterOfTender.size()>0){
                LetterOfTender threeLetter=ThreeLetterOfTender.get(0);
                BeanUtils.copyProperties(threeLetter,threeDTO);
                vo.setThreeBidCompany(threeDTO);
            }
            voList.add(vo);
        }
        return voList;
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
