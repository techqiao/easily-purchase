package com.epc.tendering.service.service.purchase.impl;

import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.constants.ErrorMessagesEnum;
import com.epc.common.exception.BusinessException;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfo;
import com.epc.tendering.service.domain.purchase.TPurchaseProjectBasicInfoCriteria;
import com.epc.tendering.service.mapper.participant.TPurchaseProjectParticipantMapper;
import com.epc.tendering.service.mapper.purchase.TPurchaseProjectBasicInfoMapper;
import com.epc.tendering.service.service.purchase.TPurchaseProjectBasicInfoService;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfo;
import com.epc.web.facade.terdering.purchase.handle.HandlePurchaseProjectBasicInfoSub;
import com.epc.web.facade.terdering.purchase.query.QueryPurchaseBasicInfoVO;
import com.epc.web.facade.terdering.purchase.vo.PurchaseProjectBasicInfoVO;
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
 * <p>Description : 采购项目实现类
 * <p>Date : 2018-09-18 19:08
 * <p>@Author : wjq
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TPurchaseProjectBasicInfoServiceImpl implements TPurchaseProjectBasicInfoService {
    @Autowired
    private TPurchaseProjectBasicInfoMapper tPurchaseProjectBasicInfoMapper;
    @Autowired
    private TPurchaseProjectParticipantMapper tPurchaseProjectParticipantMapper;

    @Override
    public Result<Boolean> handlePurchaseProjectBasicInfo(HandlePurchaseProjectBasicInfoSub handlePurchaseProjectBasicInfoSub) {
        //不全权委托招标代理机构
        if(Const.IS_OTHER_AGENCY.NOT_OTHER_AGENCY==handlePurchaseProjectBasicInfoSub.getIsOtherAgency()){
            TPurchaseProjectBasicInfo pojo = new TPurchaseProjectBasicInfo();
            BeanUtils.copyProperties(handlePurchaseProjectBasicInfoSub, pojo);
            pojo.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
            pojo.setCreateAt(new Date());
            try {
                if(pojo.getId() == null){
                    tPurchaseProjectBasicInfoMapper.insertSelective(pojo);
                    //TODO
                    //批复人
                    //负责人
                    //经办人ID
                    Integer agentId = handlePurchaseProjectBasicInfoSub.getAgentId();
                    //审核人ID
                    Integer auditorId = handlePurchaseProjectBasicInfoSub.getAuditorId();
                }else {
                   tPurchaseProjectBasicInfoMapper.updateByPrimaryKeySelective(pojo);

                }
            }catch (BusinessException e){
                return Result.error(ErrorMessagesEnum.FAILURE);
            }catch (Exception e){
                return Result.error(e.getMessage());
            }
        }
        //全权委托招标代理机构
        else {
            //TODO
            return null;
        }
        return null;

    }

    @Override
    public Result<PurchaseProjectBasicInfoVO> getPurchaseProjectBasicInfo(Long id) {
        TPurchaseProjectBasicInfo tProjectBasicInfo = tPurchaseProjectBasicInfoMapper.selectByPrimaryKey(id);
        PurchaseProjectBasicInfoVO projectDetailInfoVO = new PurchaseProjectBasicInfoVO();
        if (tProjectBasicInfo==null){
            return Result.success(null);
        }
        BeanUtils.copyProperties(tProjectBasicInfo, projectDetailInfoVO);
        return Result.success(projectDetailInfoVO);
    }

    @Override
    public Result<List<PurchaseProjectBasicInfoVO>> getPurchaseProjectList(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO) {
        final TPurchaseProjectBasicInfoCriteria criteria = new TPurchaseProjectBasicInfoCriteria();
        final TPurchaseProjectBasicInfoCriteria.Criteria subCriteria = criteria.createCriteria();
        criteriaBuild(queryPurchaseBasicInfoVO, criteria, subCriteria);
        List<PurchaseProjectBasicInfoVO> returnList = new ArrayList<>();
        List<TPurchaseProjectBasicInfo> infoList = tPurchaseProjectBasicInfoMapper.selectByExampleWithRowbounds(criteria, queryPurchaseBasicInfoVO.getRowBounds());
        infoList.forEach(item -> {
            PurchaseProjectBasicInfoVO pojo = new PurchaseProjectBasicInfoVO();
            BeanUtils.copyProperties(item, pojo);
            returnList.add(pojo);
        });
        return Result.success(returnList);
    }

    private void criteriaBuild(QueryPurchaseBasicInfoVO queryPurchaseBasicInfoVO, TPurchaseProjectBasicInfoCriteria criteria, TPurchaseProjectBasicInfoCriteria.Criteria subCriteria) {
        criteria.setOrderByClause("id desc");
        //采购分类
        if(StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseCategory())) {
            subCriteria.andPurchaseCategoryEqualTo(queryPurchaseBasicInfoVO.getPurchaseCategory());
        }
        //采购类型
        if(StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseType())) {
            subCriteria.andPurchaseTypeEqualTo(queryPurchaseBasicInfoVO.getPurchaseType());
        }
        //采购方式
        if(StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseMode())) {
            subCriteria.andPurchaseModeEqualTo(queryPurchaseBasicInfoVO.getPurchaseMode());
        }
        //采购项目状态
        if(StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseProjectStatus())) {
            subCriteria.andPurchaseProjectStatusEqualTo(queryPurchaseBasicInfoVO.getPurchaseProjectStatus());
        }
        //采购项目编号
        if(StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseProjectCode())) {
            subCriteria.andPurchaseProjectCodeEqualTo(queryPurchaseBasicInfoVO.getPurchaseProjectCode());
        }
        //采购项目名称
        if(StringUtils.isNotBlank(queryPurchaseBasicInfoVO.getPurchaseProjectName())) {
            subCriteria.andPurchaseProjectNameEqualTo(queryPurchaseBasicInfoVO.getPurchaseProjectName());
        }
        //开始时间
        if(queryPurchaseBasicInfoVO.getPurchaseStartTime() != null) {
            subCriteria.andPurchaseStartTimeGreaterThanOrEqualTo(queryPurchaseBasicInfoVO.getPurchaseStartTime());
        }
        //结束时间
        if(queryPurchaseBasicInfoVO.getPurchaseEndTime() != null) {
            subCriteria.andPurchaseStartTimeLessThanOrEqualTo(queryPurchaseBasicInfoVO.getPurchaseEndTime());
        }
    }
}
