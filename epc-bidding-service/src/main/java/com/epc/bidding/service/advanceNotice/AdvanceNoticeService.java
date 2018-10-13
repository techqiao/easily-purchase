package com.epc.bidding.service.advanceNotice;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.notice.PretrialMessageDTO;
import com.epc.web.facade.bidding.query.notice.PretrialMessageDetailDTO;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import com.epc.web.facade.bidding.vo.PretrialMessageDetailVO;

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


    /**
     * 是否通过预审
     * @param pretrialMessageDTO
     * @return
     */
    Boolean getPretrialMessage(PretrialMessageDTO pretrialMessageDTO);


    /**
     * 招标文件详情
     * @return
     */
    PretrialMessageDetailVO getPretrigetPretrialMessageDetail(Long procurementProjectId);
}
