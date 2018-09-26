package com.epc.web.facade.bidding;

import com.epc.common.Result;
import com.epc.web.facade.bidding.query.winBid.QueryWinBidLetterDTO;
import com.epc.web.facade.bidding.vo.TWinBidNominateVO;
import com.epc.web.facade.bidding.vo.WinBidLetterVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FacadeWinBidService {

    /**
     * 获取 中标通知书列表
     * @param dto
     * @return
     */
    @PostMapping(value = "getWinBidLetter", consumes = "application/json; charset=UTF-8")
    Result<List<WinBidLetterVO>> getWinBidLetter(@RequestBody  QueryWinBidLetterDTO dto);

    @PostMapping(value = "getTWinBidNominate", consumes = "application/json; charset=UTF-8")
     Result<TWinBidNominateVO> getTWinBidNominate(Long bidId);

    }
