package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.common.util.FTPUtil;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDTO;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDetailDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.notice.NoticeClient;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
* @Description:  招标公告
* @Author: linzhixiang
* @Date: 2018/9/18
*/
@Api(value = "招标公告服务",tags = "招标公告")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingNoticeController extends BaseController {

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
    public Result<NoticeDetailVO> getProjectList(@RequestBody  ClientNoticeDetailDTO dto){
        QueryNoticeDetail queryNoticeDetail=new QueryNoticeDetail();
        queryNoticeDetail.setSupplierId(getLoginUser().getBossId());
        BeanUtils.copyProperties(dto,queryNoticeDetail);
        //判断下载文件是否已支付（true:支付）
        QueryProgramPayDTO queryProgramPayDTO=new QueryProgramPayDTO();
        BeanUtils.copyProperties(dto.getClientFilePay(),queryProgramPayDTO);
        queryProgramPayDTO.setCompanyId(getLoginUser().getBossId());
        Boolean isPay=noticeClient.isPayForProjectFile(queryProgramPayDTO);
        queryNoticeDetail.setIsPay(isPay);
        if(isPay!=null){
            return  noticeClient.getNoticeDetail(queryNoticeDetail);
        }else{
            return Result.error("尚未发布招标文件");
        }
    }

}
