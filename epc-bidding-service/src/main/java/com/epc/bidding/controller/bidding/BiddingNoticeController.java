package com.epc.bidding.controller.bidding;

import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeNoticeService;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:投标接口
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@RestController
public class BiddingNoticeController implements FacadeNoticeService {

    @Autowired
    BiddingService biddingService;

    /**
     * 查看招标公告列表
     * @param queryNoticeDTO
     * @return
     */
    @Override
    public Result<List<NoticeDetailVO>> queryBIssueDocumentsList(@RequestBody QueryNoticeDTO queryNoticeDTO) {
        return biddingService.findBySupplierId(queryNoticeDTO);
    }


    /**
     * 根据Id查看招标公告详情
     * @param queryNoticeDetail
     * @param isPay
     * @return
     */
    @Override
    public Result<NoticeDetailVO> getNoticeDetail(QueryNoticeDetail queryNoticeDetail,Boolean isPay) {
        return biddingService.findByNoticeId(queryNoticeDetail,isPay);
    }

}
