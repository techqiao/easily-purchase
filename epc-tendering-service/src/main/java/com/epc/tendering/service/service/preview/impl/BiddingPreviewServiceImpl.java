package com.epc.tendering.service.service.preview.impl;

import com.epc.common.PagerParam;
import com.epc.common.Result;
import com.epc.common.constants.BiddingPreviewStatusEnum;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.preview.TBiddingPreview;
import com.epc.tendering.service.domain.preview.TBiddingPreviewCriteria;
import com.epc.tendering.service.mapper.preview.TBiddingPreviewMapper;
import com.epc.tendering.service.service.preview.BiddingPreviewService;
import com.epc.web.facade.terdering.preview.dto.QueryPageDTO;
import com.epc.web.facade.terdering.preview.dto.QueryWhere;
import com.epc.web.facade.terdering.preview.handle.PreviewHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description : easily-purchase
 * <p>Date : 2018-09-20 16:47
 * <p>@Author : luozhixin
 * <p>BiddingPreviewServiceImpl
 */
@Service
public class BiddingPreviewServiceImpl implements BiddingPreviewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BiddingPreviewServiceImpl.class);

    @Autowired
    private TBiddingPreviewMapper tBiddingPreviewMapper;

    /**
     * 新增预告
     *
     * @param previewHandle
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> insertPreview(PreviewHandle previewHandle) {
        Date date = new Date();
        TBiddingPreview tBiddingPreview = new TBiddingPreview();
        tBiddingPreview.setCreator(previewHandle.getCreator());
        tBiddingPreview.setOperateId(previewHandle.getSetOperateId());
        tBiddingPreview.setCreateAt(date);
        tBiddingPreview.setUpdateAt(date);
        tBiddingPreview.setStatus(BiddingPreviewStatusEnum.CREATED.getCode());
        tBiddingPreview.setIsDeleted(Const.IS_DELETED.NOT_DELETED);
        tBiddingPreview.setPurchaserId(previewHandle.getPurchaserId());
        tBiddingPreview.setPreviewMemo(previewHandle.getPreviewMemo());
        tBiddingPreview.setPreviewTitle(previewHandle.getPreviewTitle());
        tBiddingPreview.setProjectCode(previewHandle.getProjectCode());
        tBiddingPreview.setProjectId(previewHandle.getProjectId());
        tBiddingPreview.setProjectName(previewHandle.getProjectName());
        try {
            return Result.success(tBiddingPreviewMapper.insert(tBiddingPreview) > 0);
        } catch (Exception e) {
            LOGGER.error("BusinessException tBiddingPreviewMapperinsert : {}", e);
            return Result.error();
        }
    }

    /**
     * 查询所有预告 分页展示
     *
     * @param queryPageDTO
     * @return
     */
    @Override
    public Result selectPreview(QueryPageDTO queryPageDTO) {
        final TBiddingPreviewCriteria criteria = new TBiddingPreviewCriteria();
        final TBiddingPreviewCriteria.Criteria subCriteria = criteria.createCriteria();
        if(queryPageDTO.getProjectId() != null){
            subCriteria.andProjectIdEqualTo(queryPageDTO.getProjectId());
        }
        if(queryPageDTO.getStartTime()!=null){
            subCriteria.andCreateAtGreaterThanOrEqualTo(queryPageDTO.getStartTime());
        }
        if(queryPageDTO.getEndTime()!=null){
            subCriteria.andCreateAtLessThanOrEqualTo(queryPageDTO.getEndTime());
        }
        try {
            List<TBiddingPreview> tBiddingPreviews = tBiddingPreviewMapper.selectByExample(criteria);
            List<TBiddingPreview> returnList = new ArrayList<>();
            tBiddingPreviews.forEach(item -> {
                TBiddingPreview pojo = new TBiddingPreview();
                BeanUtils.copyProperties(item, pojo);
                returnList.add(pojo);
            });
            return Result.success(returnList);
        } catch (Exception e) {
            LOGGER.error("BusinessException tBiddingPreviewMapperSelectPreview : {}", e);
            return Result.error();
        }

    }

    /**
     * 预告详情
     *
     * @param queryWhere
     * @return
     */
    @Override
    public Result queryPreview(QueryWhere queryWhere) {
        try {
            return Result.success(tBiddingPreviewMapper.selectByPrimaryKey(queryWhere.getPreviewId()));
        } catch (Exception e) {
            LOGGER.error("BusinessException tBiddingPreviewMapperQueryPreview : {}", e);
            return Result.error();
        }
    }

    /**
     * 在时间段来的分页展示
     *
     * @param pagerParam
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Result queryByDate(PagerParam pagerParam, String startDate, String endDate) {
        Date startDateAs = new Date(startDate);
        Date endDateAs = new Date(startDate);
        TBiddingPreviewCriteria criteria = new TBiddingPreviewCriteria();
        TBiddingPreviewCriteria.Criteria subCriteria = criteria.createCriteria();
        criteria.setOrderByClause("id desc");
        subCriteria.andCreateAtBetween(startDateAs, endDateAs);
        try {
            List<TBiddingPreview> tBiddingPreviews = tBiddingPreviewMapper.selectByExampleWithRowbounds(criteria, pagerParam.getRowBounds());
            List<TBiddingPreview> returnList = new ArrayList<>();
            tBiddingPreviews.forEach(item -> {
                TBiddingPreview pojo = new TBiddingPreview();
                BeanUtils.copyProperties(item, pojo);
                returnList.add(pojo);
            });
            return Result.success(returnList);
        } catch (Exception e) {
            LOGGER.error("BusinessException tBiddingPreviewMapperQueryByDate : {}", e);
            return Result.error();
        }
    }
}
