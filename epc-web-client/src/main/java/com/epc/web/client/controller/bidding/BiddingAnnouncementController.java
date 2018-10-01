package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.query.notice.ClientAdvanceNoticeDTO;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.notice.NoticeClient;
import com.epc.web.facade.bidding.query.notice.QueryAdvanceNoticeDTO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeDetailVO;
import com.epc.web.facade.bidding.vo.AdvanceNoticeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: linzhixiang
 * @Date: 2018/9/30
 */
@Api(value = "投标--预告查询",tags = "投标--预告查询")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BiddingAnnouncementController extends BaseController {

    @Autowired
    NoticeClient noticeClient;

    @PostMapping("listAdvanceNotice")
    @ApiOperation(value = "查询预告列表",tags = "供应商预告查询")
    public Result<List<AdvanceNoticeVO>> listAdvanceNotice(@RequestBody  ClientAdvanceNoticeDTO dto){
        QueryAdvanceNoticeDTO queryAdvanceNoticeDTO=new QueryAdvanceNoticeDTO();
        BeanUtils.copyProperties(dto,queryAdvanceNoticeDTO);
       return noticeClient.listAdvanceNotice(queryAdvanceNoticeDTO);
    }


    @GetMapping(value = "AdvanceNoticeDetail", consumes = "application/json; charset=UTF-8")
    @ApiOperation(value = "查询预告详情",tags = "查询预告详情")
    Result<AdvanceNoticeDetailVO> AdvanceNoticeDetail(@RequestParam("id")  Long id){
        return noticeClient.AdvanceNoticeDetail(id);
    }


}
