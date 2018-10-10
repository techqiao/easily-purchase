package com.epc.bidding.controller.notice;

import com.epc.bidding.service.advanceNotice.AdvanceNoticeService;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeNoticeService;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
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
    @Autowired
    AdvanceNoticeService advanceNoticeService;
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
     * 根据Id查看招标公告详情 及 附件路径
     * @param queryNoticeDetail
     * @return
     */
    @Override
    public Result<NoticeDetailVO> getNoticeDetail(@RequestBody QueryNoticeDetail queryNoticeDetail) {
        return biddingService.findByNoticeId(queryNoticeDetail);
    }


    /**
     * 是否支付下载文件金额
     * @param dto
     * @return
     */

    @Override
    public Boolean isPayForProjectFile(@RequestBody QueryProgramPayDTO dto){
        return biddingService.IsPayForProjectFile(dto);
    }

    /**
     * 查询预告列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<AdvanceNoticeVO>> listAdvanceNotice(@RequestBody QueryAdvanceNoticeDTO dto){
        return advanceNoticeService.ListAdvanceNotice(dto);
    }

    /**
     * 预告详情
     * @param id
     * @return
     */
    @Override
    public Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(Long id){
        return advanceNoticeService.AdvanceNoticeDetail(id);

    }

}
