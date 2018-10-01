package com.epc.web.client.controller.bidding;

import com.epc.common.Result;
import com.epc.web.client.controller.bidding.handle.winBid.ClientWinBid;
import com.epc.web.client.controller.bidding.query.winBid.ClientWinBidLetter;
import com.epc.web.client.remoteApi.bidding.winBid.WinBidClient;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "中标通知书服务",tags = "获取中标通知书列表")
@RestController
@RequestMapping(value = "/bidding", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

public class BiddingWinBidController {

    @Autowired
    WinBidClient winBidClient;

    /**
     * 获取中标通知书列表
     * @param dto
     * @return
     */
    @PostMapping(value = "/getWinBidLetter", consumes = "application/json; charset=UTF-8")
    public Result<List<WinBidLetterVO>> getWinBidLetter(@RequestBody ClientWinBidLetter dto){
        QueryWinBidLetterDTO queryWinBidLetterDTO=new QueryWinBidLetterDTO();
        BeanUtils.copyProperties(dto,queryWinBidLetterDTO);
        return  winBidClient.getWinBidLetter(queryWinBidLetterDTO);
    }


    /**
     * 获取中标公示记录
     * @param bidId
     * @return
     */
    @PostMapping(value = "/getTWinBidNominate", consumes = "application/json; charset=UTF-8")
    public  Result<TWinBidNominateVO> getTWinBidNominate(@RequestParam("bidId") Long bidId){
        return  winBidClient.getTWinBidNominate(bidId);
    }


    /**
     * 新增中标公示记录
     * @param clientWinBid
     * @return
     */
    @PostMapping(value = "/insertTWinBidNominate", consumes = "application/json; charset=UTF-8")
    public Result<Boolean> insertTWinBidNominate(@RequestBody ClientWinBid clientWinBid) {
        HandleWinBid handleWinBid=new HandleWinBid();
        BeanUtils.copyProperties(clientWinBid,handleWinBid);
        return winBidClient.insertTWinBidNominate(handleWinBid);
    }


}
