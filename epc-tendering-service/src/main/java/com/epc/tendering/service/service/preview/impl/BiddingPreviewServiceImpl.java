package com.epc.tendering.service.service.preview.impl;

import com.epc.common.Result;
import com.epc.common.constants.BiddingPreviewStatusEnum;
import com.epc.common.constants.Const;
import com.epc.tendering.service.domain.preview.TBiddingPreview;
import com.epc.tendering.service.domain.preview.TBiddingPreviewCriteria;
import com.epc.tendering.service.mapper.preview.TBiddingPreviewMapper;
import com.epc.tendering.service.service.preview.BiddingPreviewService;
import com.epc.web.facade.terdering.preview.dto.QueryPreviewDTO;
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
            return Result.success(tBiddingPreviewMapper.insert(tBiddingPreview)>0);
        } catch (Exception e) {
            LOGGER.error("BusinessException tBiddingPreviewMapperinsert : {}", e);
           return Result.error();
        }
    }

    /**
     * 查询所有预告 分页展示
     * @param queryPreviewDTO
     * @return
     */
    @Override
    public Result selectPreview(QueryPreviewDTO queryPreviewDTO) {
        final TBiddingPreviewCriteria criteria = new TBiddingPreviewCriteria();
         criteria.createCriteria().andIdIsNotNull();
        try {
            List<TBiddingPreview>  tBiddingPreviews = tBiddingPreviewMapper.selectByExampleWithRowbounds(criteria, queryPreviewDTO.getRowBounds());
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
     * @param queryWhere
     * @return
     */
    @Override
    public Result queryPreview(QueryWhere queryWhere) {
        try {
           return Result.success( tBiddingPreviewMapper.selectByPrimaryKey(queryWhere.getPrID()));
        } catch (Exception e) {
            LOGGER.error("BusinessException tBiddingPreviewMapperQueryPreview : {}", e);
            return Result.error();
        }
    }

    /**
     * 在时间段来的分页展示
     * @param queryPreviewDTO
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Result queryByDate(QueryPreviewDTO queryPreviewDTO, Date startDate, Date endDate ) {
        TBiddingPreviewCriteria criteria = new TBiddingPreviewCriteria();
        TBiddingPreviewCriteria.Criteria subCriteria = criteria.createCriteria();
        subCriteria.andCreateAtBetween(startDate,endDate);
        try {
            List<TBiddingPreview> tBiddingPreviews = tBiddingPreviewMapper.selectByExampleWithRowbounds(criteria, queryPreviewDTO.getRowBounds());
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
