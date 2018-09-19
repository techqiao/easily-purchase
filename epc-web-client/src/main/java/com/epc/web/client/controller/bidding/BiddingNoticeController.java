package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDTO;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDetailDTO;
import com.epc.web.client.remoteApi.bidding.notice.NoticeClient;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
* @Description:  查看招标公告
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@Api(value = "投标流程",tags = {"招标列表"})
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingNoticeController {

    @Autowired
    NoticeClient biddingClient;
    @ApiOperation(value = "公告列表")
    @PostMapping(value="/getNoticeList")
    public Result<List<NoticeDetailVO>> getProjectList(@RequestBody ClientNoticeDTO clientNoticeDTO){
        QueryNoticeDTO queryNoticeDTO=new QueryNoticeDTO();
        BeanUtils.copyProperties(clientNoticeDTO,queryNoticeDTO);
        return  biddingClient.queryBIssueDocumentsList(queryNoticeDTO);
    }


    @ApiOperation(value = "公告详情")
    @PostMapping(value="/getNoticeDetail")
    public Result<NoticeDetailVO> getProjectList(@RequestBody ClientNoticeDetailDTO dto,Boolean isPay){
        QueryNoticeDetail queryNoticeDetail=new QueryNoticeDetail();
        BeanUtils.copyProperties(dto,queryNoticeDetail);
        return  biddingClient.getNoticeDetail(queryNoticeDetail,isPay);
    }
}
