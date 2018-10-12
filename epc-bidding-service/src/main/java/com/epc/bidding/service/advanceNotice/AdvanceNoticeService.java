package com.epc.bidding.service.advanceNotice;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;

import java.util.List;

/**
 * @Description: 预告业务
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */ 
public interface AdvanceNoticeService {

    /**
     * 查询预告列表
     * @param dto
     * @return
     */
     Result<List<AdvanceNoticeVO>> ListAdvanceNotice(QueryAdvanceNoticeDTO dto);

    /**
     * 详情
     * @param id
     * @return
     */
     Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(Long id);

    }
