package com.epc.bidding.controller.bidding;

import com.epc.bidding.service.winBid.WinBidService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeWinBidService;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @Description:  中标公告
* @Author: linzhixiang
* @Date: 2018/9/22
*/
@RestController
public class BiddingWinBidController implements FacadeWinBidService {

    @Autowired
    WinBidService winBidService;

    /**
     * 获取中标通知书列表
     * @param dto
     * @return
     */
    @Override
    public Result<List<WinBidLetterVO>> getWinBidLetter(@RequestBody  QueryWinBidLetterDTO dto){

        return winBidService.getWinBidLetter(dto);
    }


    /**
     * 获取中标通知列表
     * @param bidId
     * @return
     */
    @Override
    public Result<TWinBidNominateVO> getTWinBidNominate(Long bidId){
        return winBidService.getTWinBidNominate(bidId);
    }


    /**
     * 确认中标人和上传中标通知书
     * @param handleWinBid
     * @return
     */
    @Override
    public Result<Boolean> insertTWinBidNominate(@RequestBody HandleWinBid handleWinBid) {
        return winBidService.insertTWinBidNominate(handleWinBid);
    }


}
