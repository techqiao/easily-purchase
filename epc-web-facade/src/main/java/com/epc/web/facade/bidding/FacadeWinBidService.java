package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.handle.HandleWinBid;
import com.epc.web.facade.bidding.handle.HandleWinBidFilePath;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping(value = "getWinBidLetter")
    Result<List<WinBidLetterVO>> getWinBidLetter(@RequestBody  QueryWinBidLetterDTO dto);


    /**
     * 获取中标通知列表
     * @param purchaseProjectId
     * @return
     */
    @GetMapping(value = "tWinBidNominate", consumes = "application/json; charset=UTF-8")
    Result<List<TWinBidNominateVO>> getTWinBidNominate(@RequestParam("purchaseProjectId") Long purchaseProjectId);



    /**
     * 确认中标人和上传中标通知书
     * @param handleWinBid
     * @return
     */
    @PostMapping(value = "insertTWinBidNominate", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertTWinBidNominate(@RequestBody HandleWinBid handleWinBid) ;



    /**
     * 确认上传中标公示路径
     * @param handleWinBidFilePath
     * @return
     */
    @PostMapping(value = "insertTWinBidNominateFilePath", consumes = "application/json; charset=UTF-8")
    Result<Boolean> insertTWinBidNominateFilePath(@RequestBody HandleWinBidFilePath handleWinBidFilePath);
}
