package com.epc.bidding.controller.notice;

import com.epc.bidding.service.advanceNotice.AdvanceNoticeService;
import com.epc.bidding.service.bidding.BiddingService;
import com.epc.common.QueryRequest;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeNoticeService;
import com.epc.web.facade.bidding.query.notice.*;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.PretrialMessageDetailVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
* @Description:投标接口
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@RestController
public class BiddingNoticeController extends QueryRequest implements FacadeNoticeService {

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
    public Result<Map<String, Object>> queryBIssueDocumentsList(@RequestBody QueryNoticeDTO queryNoticeDTO) {
        PageHelper.startPage(queryNoticeDTO.getPageNum(),queryNoticeDTO.getPageSize());
        List<NoticeDetailVO> voList=biddingService.findBySupplierId(queryNoticeDTO);
        PageInfo<NoticeDetailVO> pageInfo = new PageInfo<>(voList);
        Map<String, Object> dataTable = getDataTable(pageInfo);

        return Result.success(dataTable);
    }


    /**
     * 根据Id查看招标公告详情 及 附件路径
     * @param queryNoticeDetail
     * @return
     */
    @Override
    public NoticeDetailVO getNoticeDetail(@RequestBody QueryNoticeDetail queryNoticeDetail) {
        return biddingService.findByNoticeId(queryNoticeDetail);
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


    /**
     * 是否通过预审
     * @param pretrialMessageDTO
     * @return
     */
    @Override
    public Result<Boolean> getPretrialMessage(@RequestBody PretrialMessageDTO pretrialMessageDTO) {
        return Result.success(advanceNoticeService.getPretrialMessage(pretrialMessageDTO));
    }

    /**
     * 获取招标文件信息
     * @return
     */
    @Override
    public Result<PretrialMessageDetailVO> getPretrigetPretrialMessageDetail( Long procurementProjectId) {
        return Result.success(advanceNoticeService.getPretrigetPretrialMessageDetail(procurementProjectId));
    }

}
