package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FacadeWinBidService {

    /**
     * 获取 中标通知书列表
     * @param dto
     * @return
     */

    @PostMapping(value = "getWinBidLetter", consumes = "application/json; charset=UTF-8")
    Result<List<WinBidLetterVO>> getWinBidLetter(@RequestBody  QueryWinBidLetterDTO dto);


    /**
     * 获取中标通知列表
     * @param bidId
     * @return
     */
    @PostMapping(value = "getTWinBidNominate", consumes = "application/json; charset=UTF-8")
     Result<TWinBidNominateVO> getTWinBidNominate(@RequestParam("bidId") Long bidId);



    /**
     * 确认中标人和上传中标通知书
     * @param handleWinBid
     * @return
     */
    @PostMapping(value = "insertTWinBidNominate", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertTWinBidNominate(@RequestBody HandleWinBid handleWinBid) ;


    }
