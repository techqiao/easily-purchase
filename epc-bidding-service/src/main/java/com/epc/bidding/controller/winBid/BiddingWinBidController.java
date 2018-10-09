package com.epc.bidding.controller.winBid;

import com.epc.bidding.service.winBid.WinBidService;
import com.epc.common.Result;
import com.epc.web.facade.bidding.FacadeWinBidService;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.handle.HandleWinBidFilePath;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 获取中标公示列表
     * @param purchaseProjectId
     * @return
     */
    @Override
    public Result<List<TWinBidNominateVO>> getTWinBidNominate(Long purchaseProjectId){
        return winBidService.getTWinBidNominate(purchaseProjectId);
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


    @Override
    public Result<Boolean> insertTWinBidNominateFilePath(@RequestBody HandleWinBidFilePath handleWinBidFilePath){
        return winBidService.insertTWinBidNominateFilePath(handleWinBidFilePath);
    }


}
