package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
     * 根据公告ID 查看公告详情
     * @param queryNoticeDetail
     * @return
     */
    @PostMapping(value = "getNoticeDetail", consumes = "application/json; charset=UTF-8")
    Result<NoticeDetailVO>  getNoticeDetail(@RequestBody QueryNoticeDetail queryNoticeDetail,Boolean isPay);

}


