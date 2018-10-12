package com.epc.web.client.controller.bidding;


import com.epc.common.Result;
import com.epc.common.constants.Const;
import com.epc.common.util.FTPUtil;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDTO;
import com.epc.web.client.controller.bidding.query.notice.ClientNoticeDetailDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.moneyPay.MoneyPayClient;
import com.epc.web.client.remoteApi.bidding.notice.NoticeClient;
import com.epc.web.facade.bidding.dto.IsPayDTO;
import com.epc.web.facade.bidding.query.downLoad.QueryProgramPayDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDTO;
import com.epc.web.facade.bidding.query.notice.QueryNoticeDetail;
import com.epc.web.facade.bidding.vo.BankAccountVO;
import com.epc.web.facade.bidding.vo.NoticeDetailVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

        //判断下载文件是否已支付（true:支付）
        QueryProgramPayDTO queryProgramPayDTO=new QueryProgramPayDTO();
        BeanUtils.copyProperties(dto,queryProgramPayDTO);
        queryProgramPayDTO.setCompanyId(getLoginUser().getBossId());
        queryProgramPayDTO.setProcurementProjectId(noticeDetailVO.getProcurementProjectId());
        IsPayDTO isPay=moneyPayClient.isPayForProjectFile(queryProgramPayDTO);

        if(isPay.getIsPay()==null){
            return Result.error("尚未发布招标文件");
        }else if(isPay.getIsPay()==false){
            noticeDetailVO.setBiddingDocumentsUrl(null);
            BankAccountVO bankAccount=moneyPayClient.getBankAccount(Const.PAYMENT_TYPE.DOCUMENTS);
            bankAccount.setMoney(isPay.getMoney());
            noticeDetailVO.setBankAccountVO(bankAccount);
        }
        return Result.success(noticeDetailVO);
    }
}
