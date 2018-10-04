package com.epc.bidding.service.advanceNotice.impl;

import com.epc.bidding.domain.bidding.TBiddingPreview;
import com.epc.bidding.domain.bidding.TBiddingPreviewCriteria;
import com.epc.bidding.mapper.bidding.TBiddingPreviewMapper;
import com.epc.bidding.service.advanceNotice.AdvanceNoticeService;
import com.epc.common.Result;
import com.epc.common.constants.BiddingPreviewStatusEnum;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 预告
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
@Service
public class AdvanceNoticeServiceImpl implements AdvanceNoticeService {

    @Autowired
    TBiddingPreviewMapper tBiddingPreviewMapper;

    /**
     * 查看 预告列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<AdvanceNoticeVO>> ListAdvanceNotice(QueryAdvanceNoticeDTO dto){
        TBiddingPreviewCriteria criteria=new TBiddingPreviewCriteria();
        TBiddingPreviewCriteria.Criteria cubCriteria=criteria.createCriteria();
        cubCriteria.andStatusEqualTo(BiddingPreviewStatusEnum.RELEASE.getCode());
        if(StringUtils.isNotEmpty(dto.getProjectCode())){
            cubCriteria.andProjectCodeLike("%"+dto.getProjectCode()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getProjectName())){
            cubCriteria.andProjectNameLike("%"+dto.getProjectName()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getPreviewTitle())){
            cubCriteria.andPreviewTitleLike("%"+dto.getPreviewTitle()+"%");
        }
        if(StringUtils.isNotEmpty(dto.getPreviewMemo())){
            cubCriteria.andPreviewMemoLike("%"+dto.getPreviewMemo()+"%");
        }
        List<TBiddingPreview> result= tBiddingPreviewMapper.selectByExampleWithRowbounds(criteria,dto.getRowBounds());
        List<AdvanceNoticeVO> voList=new ArrayList<>();
        for(TBiddingPreview entity:result){
           AdvanceNoticeVO vo=new AdvanceNoticeVO();
            BeanUtils.copyProperties(entity,vo);
            voList.add(vo);
       }
       return  Result.success(voList);
    }

    /**
     * 根据ID获取预告详情
     * @param id
     * @return
     */
    @Override
    public Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(Long id) {
        TBiddingPreview entity=tBiddingPreviewMapper.selectByPrimaryKey(id);
        AdvanceNoticeDetailVO vo= new AdvanceNoticeDetailVO();
        BeanUtils.copyProperties(entity,vo);
        return Result.success(vo);
    }
}
