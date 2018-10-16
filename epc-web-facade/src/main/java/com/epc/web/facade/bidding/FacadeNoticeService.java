package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.notice.*;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.PretrialMessageDetailVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
    Result<Map<String, Object>> queryBIssueDocumentsList(@RequestBody QueryNoticeDTO queryNoticeDTO);

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
         * 根据公告ID 查看公告详情
         * @param queryNoticeDetail
         * @return
         */
    @PostMapping(value = "getNoticeDetail", consumes = "application/json; charset=UTF-8")
    NoticeDetailVO  getNoticeDetail(@RequestBody QueryNoticeDetail queryNoticeDetail);


    /**
     * 是否通过预审
     * @param pretrialMessageDTO
     */
    @PostMapping(value = "getPretrialMessage", consumes = "application/json; charset=UTF-8")
    Result<Boolean> getPretrialMessage(@RequestBody PretrialMessageDTO pretrialMessageDTO);


    /**
     * 招标信息详情
     * @return
     */
    @GetMapping(value = "getPretrigetPretrialMessageDetailal", consumes = "application/json; charset=UTF-8")
    Result<PretrialMessageDetailVO> getPretrigetPretrialMessageDetail(@RequestParam("procurementProjectId") Long procurementProjectId);
}


