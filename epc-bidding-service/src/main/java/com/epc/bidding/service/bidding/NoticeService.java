package com.epc.bidding.service.bidding;

import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;

import java.util.List;

public interface NoticeService {


    /**
     * 根据供应商Id查看公告列表
     * @param queryNoticeDTO
     * @return
     */
    List<NoticeDetailVO> findBySupplierId(QueryNoticeDTO queryNoticeDTO);

    /**
     *  查看公告详情 及 下载文件路径
     * @param queryNoticeDetail 公告详情
     * @return
     */
    NoticeDetailVO findByNoticeId(QueryNoticeDetail queryNoticeDetail);

    }
