package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/** 
* @Description:  投标流程接口
* @Author: linzhixiang
* @Date: 2018/9/18 
*/ 
public interface FacadeNoticeService {

    /**
     * 查询公告列表
     * @param queryNoticeDTO
     * @return
     */
    @PostMapping(value = "queryBIssueDocumentsList", consumes = "application/json; charset=UTF-8")
    Result<List<NoticeDetailVO>> queryBIssueDocumentsList(@RequestBody QueryNoticeDTO queryNoticeDTO);

    /**
     * 查询预告列表
     * @param dto
     * @return
     */
    @PostMapping(value = "listAdvanceNotice", consumes = "application/json; charset=UTF-8")
    Result<List<AdvanceNoticeVO>> listAdvanceNotice(@RequestBody  QueryAdvanceNoticeDTO dto);


    /**
     * 查询预告详情
     * @param id
     * @return
     */
    @GetMapping(value = "AdvanceNoticeDetail", consumes = "application/json; charset=UTF-8")
    Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(@RequestParam("id") Long id);

        /**
         * 根据公告ID 查看公告详情 及 下载文件路径
         * @param queryNoticeDetail
         * @return
         */
    @PostMapping(value = "getNoticeDetail", consumes = "application/json; charset=UTF-8")
    NoticeDetailVO  getNoticeDetail(@RequestBody QueryNoticeDetail queryNoticeDetail);


    /**
     * 是否支付下载金额
     * @param dto
     * @return
     */
    @PostMapping(value = "isPayForProjectFile", consumes = "application/json; charset=UTF-8")
     Boolean isPayForProjectFile(@RequestBody QueryProgramPayDTO dto);

    }


