package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.winBid.ClientWinBid;
import com.epc.web.client.controller.bidding.handle.winBid.ClientWinBidFilePath;
import com.epc.web.client.controller.bidding.query.winBid.ClientWinBidLetter;
import com.epc.web.client.controller.common.BaseController;
import com.epc.web.client.remoteApi.bidding.winBid.WinBidClient;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.handle.HandleWinBidFilePath;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "中标通知书服务",tags = "中标通知书")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class BiddingWinBidController extends BaseController {

    @Autowired
    WinBidClient winBidClient;

    /**
     * 获取中标通知书列表
     * @param dto
     * @return
     */
    @ApiOperation(value = "获取中标通知书列表")
    @PostMapping(value = "/getWinBidLetter", consumes = "application/json; charset=UTF-8")
    public Result<List<WinBidLetterVO>> getWinBidLetter(@RequestBody ClientWinBidLetter dto){
        QueryWinBidLetterDTO queryWinBidLetterDTO=new QueryWinBidLetterDTO();
        BeanUtils.copyProperties(dto,queryWinBidLetterDTO);
        queryWinBidLetterDTO.setSupplierId(getLoginUser().getBossId());
        return  winBidClient.getWinBidLetter(queryWinBidLetterDTO);
    }


    /**
     * 获取中标公示记录
     * @param purchaseProjectId
     * @return
     */
    @ApiOperation(value = "获取中标公示记录")
    @GetMapping(value = "/getTWinBidNominate")
    public  Result<List<TWinBidNominateVO>> getTWinBidNominate(@RequestParam("purchaseProjectId") Long purchaseProjectId){
        return  winBidClient.getTWinBidNominate(purchaseProjectId);
    }


    /**
     * 新增中标公示记录
     * @param clientWinBid
     * @return
     */
    @ApiOperation(value = "新增中标公示记录")
    @PostMapping(value = "/insertTWinBidNominate", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertTWinBidNominate(@RequestBody ClientWinBid clientWinBid) {
        HandleWinBid handleWinBid=new HandleWinBid();
        BeanUtils.copyProperties(clientWinBid,handleWinBid);
        handleWinBid.setBossId(getLoginUser().getBossId());
        handleWinBid.setPurchaserId(getLoginUser().getUserId());
        return winBidClient.insertTWinBidNominate(handleWinBid);
    }

   /*
    @ApiOperation(value = "新增中标公示（文件路径）",tags = "新增中标公示（文件路径）")
    @PostMapping(value = "/insertTWinBidNominateFilePath", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertTWinBidNominatePath(@RequestBody ClientWinBidFilePath clientWinBidFilePath) {
        HandleWinBidFilePath handleWinBidFilePath=new HandleWinBidFilePath();
        BeanUtils.copyProperties(clientWinBidFilePath,handleWinBidFilePath);
        return winBidClient.insertTWinBidNominateFilePath(handleWinBidFilePath);
    }*/

}
