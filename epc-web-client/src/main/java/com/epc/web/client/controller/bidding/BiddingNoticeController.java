package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.web.client.controller.bidding.query.notice.ClientFilePay;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDTO;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDetailDTO;
import com.epc.web.client.remoteApi.bidding.notice.NoticeClient;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
* @Description:  查看招标公告
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@Api(value = "招标公告服务",description = "招标公告")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingNoticeController {

    @Autowired
    NoticeClient noticeClient;
    @ApiOperation(value = "公告列表")
    @PostMapping(value="/getNoticeList")
    public Result<List<NoticeDetailVO>> getProjectList(@RequestBody ClientNoticeDTO clientNoticeDTO){
        QueryNoticeDTO queryNoticeDTO=new QueryNoticeDTO();
        BeanUtils.copyProperties(clientNoticeDTO,queryNoticeDTO);
        return  noticeClient.queryBIssueDocumentsList(queryNoticeDTO);
    }

    @ApiOperation(value = "查看公告详情及下载文件")
    @PostMapping(value="/getNoticeDetailWithFile")
    public Result<NoticeDetailVO> getProjectList(@RequestParam("dto") ClientNoticeDetailDTO dto, @RequestParam("clientFilePay") ClientFilePay clientFilePay){
        QueryNoticeDetail queryNoticeDetail=new QueryNoticeDetail();
        BeanUtils.copyProperties(dto,queryNoticeDetail);
        //判断下载文件是否已支付（true:支付）
        QueryProgramPayDTO queryProgramPayDTO=new QueryProgramPayDTO();
        BeanUtils.copyProperties(clientFilePay,queryProgramPayDTO);
        Boolean isPay=noticeClient.isPayForProjectFile(queryProgramPayDTO).getData();
        return  noticeClient.getNoticeDetail(queryNoticeDetail,isPay);
    }

}
