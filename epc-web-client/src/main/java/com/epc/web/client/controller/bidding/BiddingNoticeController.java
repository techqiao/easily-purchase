package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDTO;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDetailDTO;
import com.epc.web.client.controller.bidding.query.notice.ClientPretrialMessageDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.file.FileClient;
import com.epc.web.client.remoteApi.bidding.moneyPay.MoneyPayClient;
import com.epc.web.client.remoteApi.bidding.notice.NoticeClient;
import com.epc.web.facade.bidding.dto.IsPayDTO;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.PretrialMessageDTO;
import com.epc.web.facade.bidding.query.notice.PretrialMessageDetailDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.BankAccountVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.epc.web.facade.bidding.vo.PretrialMessageDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @Autowired
    MoneyPayClient moneyPayClient;
    @Autowired
    FileClient fileClient;

    @ApiOperation(value = "公告列表")
    @PostMapping(value="/getNoticeList")
    public Result<Map<String, Object>> getProjectList(@RequestBody ClientNoticeDTO clientNoticeDTO){
        QueryNoticeDTO queryNoticeDTO=new QueryNoticeDTO();
        BeanUtils.copyProperties(clientNoticeDTO,queryNoticeDTO);
        queryNoticeDTO.setSupplierId(getLoginUser().getBossId());
       return noticeClient.queryBIssueDocumentsList(queryNoticeDTO);
    }

    @ApiOperation(value = "查看公告详情及下载文件")
    @PostMapping(value="/getNoticeDetailWithFile")
    public Result<NoticeDetailVO> getProjectList(@RequestBody  ClientNoticeDetailDTO dto){
        QueryNoticeDetail queryNoticeDetail=new QueryNoticeDetail();
        BeanUtils.copyProperties(dto,queryNoticeDetail);
        queryNoticeDetail.setSupplierId(getLoginUser().getBossId());
        //获取公告信息
        NoticeDetailVO noticeDetailVO=  noticeClient.getNoticeDetail(queryNoticeDetail);
        return Result.success(noticeDetailVO);
    }

    @ApiOperation(value = "是否通过预审")
    @PostMapping(value="/getIsPassPretrial")
    public Result<Boolean> getIsPassPretrial(@RequestBody ClientPretrialMessageDTO clientPretrialMessageDTO){
         PretrialMessageDTO PretrialMessageDTO=new PretrialMessageDTO();
         PretrialMessageDTO.setNoticeId(clientPretrialMessageDTO.getNoticeId());
         PretrialMessageDTO.setSupplierId(getLoginUser().getBossId());
         Result<Boolean> isPass=noticeClient.getPretrialMessage(PretrialMessageDTO);
        return  isPass;
    }

    @ApiOperation(value = "获取招标文件信息")
    @GetMapping(value="/getMessageDetail")
    public Result<PretrialMessageDetailVO> getMessageDetail(@RequestParam("procurementProjectId") Long procurementProjectId){
        PretrialMessageDetailDTO dto=new PretrialMessageDetailDTO();
        dto.setProcurementProjectId(procurementProjectId);
        Result<PretrialMessageDetailVO> entity=noticeClient.getPretrigetPretrialMessageDetail(procurementProjectId);
        return  entity;
    }

    @ApiOperation(value = "获取下载招标文件")
    @GetMapping(value="/getInvitationFile")
    public Result<IsPayDTO> getInvitationFile(@RequestParam("procurementProjectId") Long procurementProjectId){
        //判断下载文件是否已支付（true:支付）
        QueryProgramPayDTO queryProgramPayDTO=new QueryProgramPayDTO();
        queryProgramPayDTO.setCompanyId(getLoginUser().getBossId());
        queryProgramPayDTO.setProcurementProjectId(procurementProjectId);
        IsPayDTO isPay=moneyPayClient.isPayForProjectFile(queryProgramPayDTO);
        if(isPay!=null){
            if(isPay.getIsPay()==false){
                BankAccountVO bankAccountVO=moneyPayClient.getBankAccount(Const.PAYMENT_TYPE.DOCUMENTS);
                isPay.setBankAccountVO(bankAccountVO);
            }
        }
        return  Result.success(isPay);
    }
}
